package rangefinder;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.sql.DataSource;

@Named
@SessionScoped
public class RangeBean implements Serializable {
    private List<Integer> range;
    private int begin = 1;
    private int end = 1;
    
    @Resource(lookup="jdbc/ski50")
    private DataSource db;

    
    @PostConstruct
    public void init() {
        range = new ArrayList<>();
        try (Connection c = db.getConnection();
             Statement s = c.createStatement()) {
            ResultSet rs = s.executeQuery(
                    "select distinct year from results");
            while (rs.next()) {
                range.add(rs.getInt("year"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public List<Integer> getRange() {
        return range;
    }
    
    public List<Result> getValues() {
        List<Result> results = new ArrayList<>();
        try (Connection c = db.getConnection();
             PreparedStatement s = c.prepareStatement(
                "select * from results where year between ? and ?"
             )) {
            s.setInt(1, begin);
            s.setInt(2, end);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                results.add(new Result(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getTime(7)
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return results;
    }
    
    public void find() {
        
   }
}
