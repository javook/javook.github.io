
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "course")
public class course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cid;

    private String namecourse;

    @ElementCollection
    @ManyToMany(mappedBy = "cstudent")
    private List<student> scourse=new ArrayList<student>();

    @OneToOne(mappedBy = "tidcourse")
    private teacher cteacher;
//    @ManyToOne
    //private student student;
    //  @ManyToOne(fetch = FetchType.EAGER)
    //  @JoinColumn(name = "tid", foreignKey = @ForeignKey(name = "teacherid"))
//    @ManyToMany
//    private teacher teacher;

//    public course(Integer cid, String namecourse,List scourse) {
//        this.cid = cid;
//        this.namecourse = namecourse;
//        this.scourse=scourse;
//    }

    public teacher getCteacher() {
        return cteacher;
    }

    public void setCteacher(teacher cteacher) {
        this.cteacher = cteacher;
    }


    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getNamecourse() {
        return namecourse;
    }

    public void setNamecourse(String namecourse) {
        this.namecourse = namecourse;
    }

//    public teacher getTeacher() {
//        return teacher;
//    }
//
//    public void setTeacher(teacher teacher) {
//        this.teacher = teacher;
//    }

    public List<student> getScourse() {
        return scourse;
    }

    public void setScourse(List<student> scourse) {
        this.scourse = scourse;
    }


 

}
