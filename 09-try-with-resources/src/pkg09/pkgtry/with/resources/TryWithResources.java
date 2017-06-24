package pkg09.pkgtry.with.resources;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class TryWithResources {

    public static void main(String[] args) throws Exception{
        TryWithResources demo = new TryWithResources();
        demo.lueHinnasto();
        demo.vieTietokantaan();
    }
    
    private Hinnasto hinnasto;
    private Tuoteryhmä viimeisinTuoteryhmä;
    private Connection db;
        
    private void lueHinnasto() {
        
        try 
            (ZipFile zf = new ZipFile("mcdonaldsprices.zip")) 
        {
            Enumeration<? extends ZipEntry> zes = zf.entries();
            while (zes.hasMoreElements()) {
                ZipEntry ze = zes.nextElement();
                System.out.println(ze.getName());
            }
            lueHinnasto(zf.getInputStream(
                    zf.getEntry("mcdonaldsprices.txt")));
        } catch (IOException ex) {
            Logger.getLogger(
                TryWithResources.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    private void lueHinnasto(InputStream is) {
        Scanner s = new Scanner(is);
        
        hinnasto = new Hinnasto();
        
        while (s.hasNextLine()) {
            String[] kentät = s.nextLine().split("\t");
            switch (kentät.length) {
                case 1:
                    lisääTuoteryhmä(kentät);
                    break;
                case 3:
                    lisääTuote(kentät);
                    break;
                default:
                    throw new RuntimeException("Error 12N345");
            }
        }
    }

    private void lisääTuoteryhmä(String[] kentät) {
        viimeisinTuoteryhmä = new Tuoteryhmä(kentät[0]);
        hinnasto.add(viimeisinTuoteryhmä);
    }

    private void lisääTuote(String[] kentät) {
        if (viimeisinTuoteryhmä == null) {
            throw new RuntimeException("Error A2-323-x");
        }
        viimeisinTuoteryhmä.add(
            new Tuote(kentät[0], kentät[1], 
                    new BigDecimal(kentät[2].substring(1)))
        );
    }
    
    private void vieTietokantaan() throws SQLException {
        /*    
        Connection db = null;
        try {
               db = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/po-demo", 
                "demo", 
                "demo");
               
                this.db = db;
                luoHinnastotaulut();
                tallennaHinnasto();
        } finally {
            if (db != null) {
                db.close();
            }
        } */
       
        try (Connection db = DriverManager.getConnection(
            "jdbc:derby://localhost:1527/po-demo",
            "demo", 
            "demo")) {
            this.db = db;
            luoHinnastotaulut();
            tallennaHinnasto();
        }
    }

    private void luoHinnastotaulut() throws SQLException {
        
        try (Statement stmt = db.createStatement()) {
            DatabaseMetaData mtd = db.getMetaData();
        
            if(mtd 
                    .getTables(null, null, "TUOTERYHMAT", null)
                    .next()) {
                        stmt.execute("drop table tuoteryhmat");
                    }
            stmt.execute(
                      "create table tuoteryhmat ("
                      + "tuoteryhma_id int primary key,"
                      + "nimi varchar(255)) "
                );

            if(mtd
                    .getTables(null, null, "TUOTTEET", null)
                    .next()) {
                        stmt.execute("drop table tuotteet");
                    }
            stmt.execute(
                      "create table tuotteet ("
                      + "tuote_id int primary key,"
                      + "nimi varchar(255),"
                      + "annoskoko varchar(255),"
                      + "hinta decimal(10,2),"
                      + "tuoteryhma_id int)"                
                );
        }
    }

    private void tallennaHinnasto() throws SQLException {
        int tuoteryhmaId = 0;
        int tuoteId = 0;
        
        for ( Tuoteryhmä tr : hinnasto.getTuoteryhmät()) {
            ++tuoteryhmaId;
            
            try (PreparedStatement ps = db.prepareStatement(
                    "insert into tuoteryhmat values (?,?)")) {
                ps.setInt(1, tuoteryhmaId);
                ps.setString(2, tr.getNimi());
                ps.execute();
                }
            
            for (Tuote t : tr.getTuotteet()) {
                ++tuoteId;
                    try (PreparedStatement ps = db.prepareStatement(
                        "insert into tuotteet values (?,?,?,?,?)")) {
                        ps.setInt(1, tuoteId);
                        ps.setString(2, t.getNimi());
                        ps.setString(3, t.getAnnoskoko());
                        ps.setBigDecimal(4, t.getHinta());
                        ps.setInt(5, tuoteryhmaId);
                        ps.execute();
                    }
            }
        }
    }
    
}
