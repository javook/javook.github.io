
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Entity
@Table(name = "teacher")
public class teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer teacherid;

    private String tname;

    @ElementCollection
    @OneToMany(mappedBy = "steacher")
    private List<student> tstudent = new ArrayList<student>();

    @OneToOne(cascade = {CascadeType.ALL})
    private course tidcourse;



    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

//    public course getTcourse() {
//        return tcourse;
//    }
//
//    public void setTcourse(course tcourse) {
//        this.tcourse = tcourse;
//    }
//    public List<course> getTcourse() {
//        return tcourse;
//    }
//
//    public void setTcourse(List<course> tcourse) {
//        this.tcourse = tcourse;
//    }
    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public List<student> getTstudent() {
        return tstudent;
    }

    public void setTstudent(List<student> tstudent) {
        this.tstudent = tstudent;
    }

    public course getTidcourse() {
        return tidcourse;
    }

    public void setTidcourse(course tidcourse) {
        this.tidcourse = tidcourse;
    }

//    public void addTidcourse(course tidcourse) {
//tidcourse.set
//        
//    }
}
