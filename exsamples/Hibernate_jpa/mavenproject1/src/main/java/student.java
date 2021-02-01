
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alishz
 */
@Entity //tabdil class be yek entity dar database 
@Table(name = "student") //tanzim name entity be onvane yek table dar database
public class student {

    @Id //tanzim field studentid name be onvane id va unique kardane an
    @GeneratedValue(strategy = GenerationType.AUTO) // automatic kardane ijad number id baraye field studentid barasase noe paygah dade
//   @Column(name = "studentid") // tanzim name delkhah baraye in column jahate namayeshe dar database 
    private Integer studentid;

    private String sname;

    @ManyToOne(cascade = {CascadeType.ALL}) //tanzim rabete many-to-one ba object ijad shode az teacher va cascade baraye taghir kardan automatic fieldhaye mortabet ba an
    private teacher steacher;

    @ElementCollection //tanzim object cstudent be onvane yek Listcollection
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<course> cstudent = new ArrayList<course>();

//    public student(Integer studentid, String sname,teacher steacher) {
//        super();
//        this.studentid = studentid;
//        this.sname = sname;
//        this.steacher=steacher;
//    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    
    public teacher getSteacher() {
        return steacher;
    }

    public void setSteacher(teacher steacher) {
        this.steacher = steacher;
    }



    public List<course> getCstudent() {
        return cstudent;
    }

    public void setCstudent(List<course> cstudent) {
        this.cstudent = cstudent;
    }


}
