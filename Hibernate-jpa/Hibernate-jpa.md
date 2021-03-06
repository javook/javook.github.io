

# آموزش Hibernate-Jpa


 **مفهومی انتزاعی می باشد که طی آن کلاس طراحی شده باید persistant باشد** تا بتواند از Jpa استفاده کند.**مدل کار با Jpa** برخلاف Jdbc , **آبجکتی می باشد.**همچنین **Entity یا موجودیت ها در Jpa مدل های ذخیره سازی دیتا هستند که با آن می توان مدل شی گرایی را برای سهولت کار با دیتابیس به رابطه ای تبدیل کنیم.Entity ها شامل ویژگی های cdv هستند** که عبارتند از :

**persist - identity- transient - granularity**


## چرخه حیات  Entity


**چرخه  Entity عبارتست از :**

 1- **ابتدا کلاس مربوط به entity و  بعد کلاسی برای مدیریت entity ها باید  ساخته شود و در آن یک آبجکت از هر دوکلاس entitymanagerfactory و  entitymanager  ایجاد گردد.**

2- **مقداردهی اولیه خصوصیات تعریف شده سپس انجام عملیات crud در صورت نیاز**

3- **سپس یک فایل xml ایجاد و یا با قراردادن نشانه گذاری annotation بالای فیلدهای مدنظر جهت درج مشخصات مربوط به آن تعریف می شود**

4-**عملیات persist : در این مرحله پایانی ذخیره داده ها صورت می گیرد**


## نشانه گذاری های مخصوص  Annotation


همچنین**annotation های مخصوصی جهت کار با Entity ها و تعیین نقش هر کدام وجود دارد** که پرکاربرد ترین آنها عبارتند از:


**@Id تنظیم خصوصیتی بعنوان آیدی در یک جدول**
**@Table تنظیم خصوصیتی بعنوان جدول در دیتابیس(این خصوصیت جدول است)**
**@Column تنظیم خصوصیتی بعنوان ستون در دیتابیس**
**@Transient تنظیم خصوصیت های serialize**

 بعلاوه **annotation هایی برای انواع ارتباطات بین جداول دیتابیس هم کاربرد دارند 4 نوع می باشند** : 

**1-one to one@  یک به یک**
**2-one to many@  یک به چند**
**3-many to one@   چند به یک**
**4-many to many @  چند به چند**


همچنین **لیست کامل annotation های کاربردی در آدرس زیر موجود می باشد:**

 **https://dzone.com/articles/all-jpa-annotations-mapping-annotations**


##نکات مهم


**در JPA تنها می توان از سه نوع collection به همراه پیاده سازی های مختلف آن ها استفاده کرد که شامل کالکشن های Set , list , map  می باشند.**

**در پروژه های  maven فایلی تحت عنوان pom.xml به محض ایجاد پروژه ایجاد می گردد که  برای  تعریف و ذخیره پلاگین های پروژه از جمله maven و سایر پلاگین هایی که به پروژه اضافه می کنیم کاربرد دارد.** سپس **برای درج و ذخیره  تنظیمات دیتابیس پروژه maven hibernate-jpa باید فایلی تحت عنوان persistence.xml ایجاد نماییم.**


همچنین **نمونه ای از تعریف کلاس emf, pom.xml, persistence.xml و سایر جزپیات در آدرس زیر موجود هستند :**

**https://examples.javacodegeeks.com/enterprise-java/jpa/java-persistence-xml-example/**




