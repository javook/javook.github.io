## JPA 
یک ساختار انتزاعی است که برای تبدیل کلاس های برنامه به جداول پایگاه داده و بالعکس استفاده میشود و آنرا با وندور های دیتابیس مثل hibernate پیاده سازی میکنیم

## انواع نگاشت:

 1. onetomany:این عمل با عملگر @onetomany مشخص شده . بیانگر رابطه یک به چند است
 2. manytoone:با عملگر @manytoone مشخص شده و بیانگر رابطه چند به یک است
 3. onetoone با عملگز @onetoone مشخص شده و بیانگر رابطه بک به یک است
 4. manytomany:با عملگر @manytomany مشخص شده و بیانگر رابطه چند به چند است


**نکته**:در مشخص کردن روابط باید این مطلب را در نظر داشت که اگر میخواهیم چند موجودیت را با موجودیتی که در آن هستیم ارتباط دهیم باید از عملگر @manytoone استفاده کنیم و بالعکس

## entity

**entity:**
 این اصطلاح یک عنصر مهم تشکیل دهنده jpa است که به همان کلاس نوشته شده در برنامه که قرار است به یک جدول دیتابیس شود اطلاق میشود
## خصوصیات entity:

 1. قابل ذخیره بودن:یک موجودیت ماندگار است اگر یتوان ان را در دیتابیس ذخیره کرد و همیشه به ان دسترسی داشت
 2. قابلیت شناسایی:یک شی در جاوا دارای یک id است و باید در دیتابیس هم یک id داشته باشد که بتوان انرا بعنوان کلید اصلی در نظر کرفت
 3. دانه دانه باشد:یعنی از متغیر های primitive تشکیل شده باشد تا بتوان آنرا در دیتابیس ذخیره کرد

## چرخه کار با JPA
این چرخه از به طور کلی از چهار مرحله تشکیل شده که به صورت زیر هستند

 - ساختن فایل .xml که حاوی اطلاعات دیتابیس بوده و اسم آن متناسب با vendor دیتابیسی که مورد استفاده خواهد بود متفاوت است
 - Entity Manager Factory:برای ساختن یک Entity Manager باید یک شی از این کلاس ساخته شده و سپس با استفاده از آن Entity Manager را ساخت .
 - Entity Manager : از این کلاس به منظور انجام عملیات درج،خواندن،تغییر دادن و حذف (CRUD) اطلاعات از دیتابیس استفاده میشود
 - Persist: در این مرحله تغییراتی که باید برروی دیتابیس اعمال شود اتفاق می افتند
 
 ## Annotations
 
 - @Entity: برای مشخص کردن اینکه کلاسی که در آن هستیم یک Entity بوده و قرار است در دیتابیس ذخیره شود
 @Entity(name="entity name")
 
 - @table:این مورد را میتوان در Entity استفاده نکرد اما در صورت استفاده مشخص میکند جدول ساخته شده از این Entity چه خصوصیاتی داشته باشد
 @table(name="table name")
 
 - @column: در صورت استفاده از این کلیدواژه میتوان نام و مشخصات خصوصیت به خصوصی از کلاس مورد نظر را مشخص کرد
 @column(name="column name")
 
 - @Id: این مورد را برای مشخص کردن کلید اصلی جدول مورد نظر استفاده میکنیم
 - @transient:اگر خصوصیتی از کلاس داشتیم که قصد نداریم به دیتابیس اضافه شود از این کلیدواژه استفاده میکنیم

## مثال کاربردی
برای کار با jpa در maven ابتدا باید فایل pom.xml را تغییر داده و dependency های زیر را به آن اضافه کرد

```
<dependencies>
	<dependency> 
		<groupId>org.hibernate</groupId>  
		 <artifactId>hibernate-core</artifactId>  
		 <version>5.4.27.Final</version>  
	 </dependency> 
	 <dependency>
		 <groupId>org.hibernate.javax.persistence</groupId>  
		 <artifactId>hibernate-jpa-2.1-api</artifactId>  
		 <version>1.0.2.Final</version>  
	 </dependency> 
	 <dependency> 
		 <groupId>org.mariadb.jdbc</groupId>  
		 <artifactId>mariadb-java-client</artifactId>  
		 <version>2.7.1</version>  
	 </dependency>
 </dependencies>
```
پس از اضافه کردن قطعه کد بالا به pom.xml،به ساختن و تنظیم کردن فایل <<project-dir/src/main/recourses/persistence.xml>> میپردازیم و کد زیر را به آن اضافه میکنیم‍‍‍‍
```
<?xml version="1.0" encoding="UTF-8"?>  
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"  
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence  
	http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"  version="2.1"
	>  
	 <persistence-unit name="test">  
		 <class>models.Student</class>  
		 <class>models.Teacher</class>
		 <class>models.Course</class>
		 <properties> 
			 <property name="javax.persistence.jdbc.driver" value="org.mariadb.jdbc.Driver"/>  
			 <property name="javax.persistence.jdbc.url" value="jdbc:mariadb://localhost:3306/dbname" />  
			 <property name="javax.persistence.jdbc.user" value="username"/>  
			 <property name="javax.persistence.jdbc.password" value="password"/>  
			 <property name="hibernate.dialect" value="org.hibernate.dialect.MariaDB10Dialect"/>  
			 <property name="hibernate.hbm2ddl.auto" value="create"/>  
			 <property name="hibernate.show_sql" value="true"/>  
			 <property name="hibernate.format_sql" value="true"/>  
		</properties>
	</persistence-unit>
</persistence>
 ```

## معرفی تگ های استفاده شده

 - ```<persistence-unit name="test">```:در این تگ مشخصات دیتابیس و نحوه برخورد با دیتابیس هنگام اجرای برنامه را مشخص میکنیم و میتوانیم برای دیتابیس های مختلف persistence-unit های مختلف داشته باشیم
در ادامه نحوه استفاده از آن را شرح خواهیم داد
 - ‍‍‍‍‍‍```<class>```:این تگ برای شناسایی کلاس هایی به در انتها به جداول دیتابیس تبدیل میشوند استفاده میشود 
 - ```<properties>```:   
	 - ```<property name="hibernate.dialect">```:از این تگ استفاده میشود تا به صورت مشخص با توجه به نسخه دیتابیس استفاده شده از query های با performance بالا استفاده شود
	 - ```<property name="hibernate.hbm2ddl.auto">```:عملیاتی که هنگام اجرای برنامه می افتد را مشخص میکند مثلا اگر مقدار آن create-drop باشد قبل از اجرای query ها ابتدا جداول را drop و سپس create کرده و در انتها تمامی جداول را drop میکند
	 - ```<property name="show-sql">,<property name="format-sql">```:اگر برابر true قرار دهیم query های تولید شده را هنگام اجرای برنامه به صورت format در خروجی نمایش میدهد

## کلاس ها

 - Student.java
 - Teacher.java
 - Course.java
کلاس Student :این کلاس با Teacher رابطه چند به یک و با کلاس Course رابطه چند به چند دارد
کلاس Course:این کلاس با Teacher رابطه یک به یک و با Student رابطه چند به چند دارد
کلاس Teacher: این کلاس با Course رابطه چند به چند داشته و با Student رابطه یک به چند دارد

**برقرار کردن ارتباط ها**
Teacher و Student:
برای برقراری این رابطه باید یک لیست از Student در کلاس Teacher ساخته و همینظور یک شی از Teacher در کلاس Student بسازیم و آندو را با هم map کنیم تا این رابطه در نظر گرفته شود .
کد زیر رابطه بین دو کلاس را نمایش میدهد
```
import javax.persistence.*;  
import java.util.List;  
@Entity  
public class Teacher {  
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO)  
	private Integer id;  
	private String Name;  
  
	@OneToMany(mappedBy = "teacher")  
	private List<Student> studentList;
}
```

```
import javax.persistence.*;  
import javax.persistence.GeneratedValue;  
import java.util.List;  
  
@Entity  
public class Student {  
	public Student(){}  
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO)  
    private Integer id;  
	private String name;  
  
	@ManyToOne  
	private Teacher teacher;
}
```

Course و Teacher:
این رابطه بصورت یک به یک بوده و برای برقراری ارتباط باید یک شی از Course در کلاس Teacher ساخته و یک شی از کلاس Teacher در کلاس Course میسازیم و این را به شکل زیر با هم map میکنیم 

```
import javax.persistence.*;  
import java.util.ArrayList;  
import java.util.List;  
  
@Entity  
public class Course {  
	public Course(){}  
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO)  
    private Integer id;  
	private String name;  
  
	@OneToOne  
	@JoinColumn(name = "teacher_id")  
    private Teacher teacher;
}
```

```
import javax.persistence.*;  
import java.util.List;  
@Entity  
public class Teacher {  
	public Teacher(){}
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO)  
    private Integer id;  
	private String Name;  
  
	@OneToMany(mappedBy = "teacher")  
    private List<Student> studentList;  
  
	@OneToOne(mappedBy = "teacher")  
    Course course;
    }
```

Course و Student :
این رابطه به صورت چند به چند است
در فایل Student لیست ساخته شده از کلاس Course را باید با لیست ساخته شده از کلاس Student ,map کنیم
```
import javax.persistence.*;  
import javax.persistence.GeneratedValue;  
import java.util.List;  
  
@Entity  
public class Student {    
	public Student(){}
	@Id  	
	@GeneratedValue(strategy = GenerationType.AUTO)  
	private Integer id;  
	private String name; 
	@ManyToMany(mappedBy = "studentList")  
    private List<Course> courseList;
}
```

در فایل Course نیز به همین شکل باید نام جدول جدید  کلید های خارجی آن را وارد کنیم تا این ارتباط برقرار شود
```
import javax.persistence.*;  
import java.util.ArrayList;  
import java.util.List;  
  
@Entity  
public class Course {  
	public Course(){}  
    @Id  
	@GeneratedValue(strategy = GenerationType.AUTO)  
    private Integer id;  
	private String name;  
	
	@ManyToMany  
	@JoinTable(name = "student2course",  
	joinColumns = @JoinColumn(name="id"),  
	inverseJoinColumns = @JoinColumn(name = "id"))  
    private List<Student> studentList;
}
```

## self-reference
برای اینکه یک entity را با خودش ارتباط دهیم باید در همان کلاس یک شی و یک لیست یا یک شی از خودش بسته به نوع رابطه میتواند متفاوت باشد به صورت مثال زیر میسازیم

```
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import java.util.List;

@Entity
public class Student {

    public Student(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    
    @ManyToOne
    private Student intoducer;
    
    @OneToMany(mappedBy = "introducer" ,cascade = CascadeType.PERSIST)
    private List<Student> studentList;
}
```

نکته کاربردی: میتوان یک Collection با فقط یک شی در آن را ساخت و به شکل زیر در پروژه های خود از آن استفاده کرد

```
	Student.setStudentList(Collections.singleton(student));
```

## متد های  EntityManager


- getTransaction().commit():از این متد برای ذخیره اطلاعات و عملیات های انجام شده در دیتابیس استفاده میشود.
- flush(): از این متد برای ذخیره اطلاعات در دیتابیس استفاده میشود .
- persist(): از این متد برای ساختن کد دیتابیس عملیات مورد نظر استفاده میشود.
- merge(): اگر شی ورودی به این متد در جدول مورد نظر وجود داشت آنرا بروزرسانی میکند و اگر وجود نداشت آنرا به جدول اضافه میکند.
- find(): از این متد برای پیدا کردن یک field در یک جدول بخصوص در دیتابیس استفاده میشود که از متد پایین جدید تر است.
- reference(): از این متد برای پیدا کردن یک field در یک جدول بخصوص در jpa context استفاده میشود که از متد بالا سریعتر است.
- remove(): از این متد برای حذف از دیتابیس استفاده میشود.
- createQuery(): از این متد برای نوشتن دستورات jpql به صورت مستقیم استفاده میشود.
- createNamedQuery(): از این متد برای استفاده از یک namedQuery استفاده میشود.
- createNativeQuery(): از این متد برای نوشتن کد sql مربوط به دیتابیس مورد استفاده استفاده میشود که به صورت مستقیم در دیتابیس اجرا خواهد شد.

**Query و TypedQuery:**
از Query ها برای ذخیره کردن کوئری های JPQL , SQL استفاده میشود.
دقیقا همان Query است با این تفاوت که نوع کلاسی که برگزدانده میشود را از قبل میدانیم.
مثلا اگر بدانیم نوع کلاسی که از دیتابیس برگردانده میشود چیست میتوانیم از TypedQuery<Student> استفاده کنیم.
