# 11- مدیریت استثناء ها  Exception Handling


## انواع استثناء ها Exceptions


استثناها برای **مدیریت خطاها** در یک برنامه هستند.انواع گوناگونی از استثناها وجود دارد که رایج ترین آنها عبارتند از :


DivideByZeroWithExceptionHandling      هنگام تقسیم بر صفر رخ می دهد

ArrayIndexOutOfBoundsException  در صورتی که اندیس خارج از خانه های آرایه باشد رخ می دهد

ArrayStoreException       زمانی که نوع داده ای که در خانه آرایه ریخته می شود با نوع آرایه متفاوت باشد

IllegalArgumentException   وقتی که از آرگومان های ورودی نامعتبر برای فراخوانی یک متد استفاده شود

NullPointerException این استثناء زمانی رخ می دهد که از اشیائی استفاده کنیم که مقداردهی نشده و خالی هستند

FileNotFoundException            وقتی فایل مورد نظر در آدرس وجود نداشته باشد

InputMismatchException           استثنای ورود مقادیر اشتباه توسط کاربر است

InstantiationException    زمانی که بخواهیم از یک کلاس انتزاعی و یا اینترفیس شئ بسازیم داد

UnsupportedOperationException زمانی رخ می دهد که از عملیاتی استفاده شود که زبان جاوا از آن پشتیبانی نکند



برای مدیریت استثناها از **بلاک try catch** استفاده می شود. کدی که احتمالا دارای **خطا** باشد درون **بلاک try** قرار گرفته و در **بلاک catch** متغیری از **جنس Exception** خاصی که مدنظر است یا کلاس Exception که همه استثناها از آن **ارث بری** دارند تعریف می شود. می توان برای یک **متد** هم استثنا تعریف کنیم به این ترتیب که ابتدا بعد از آوردن نام متد بعد از **تعریف** آن, **کلمه کلیدی throws** سپس **جنس استثناء** آورده می شود. در مرحله بعد درون بلاک catch ابندا متغیری از جنس آن Exception ایجاد کرده و بعد مطابق دستور زیر  **new Exception** می شود : 
  Throws new Exception();

همچنین در کد بالا امکان **ارسال پیام** و **متغیر exception** به حافظه پشته ای که استثناها را ذخیره می کند وجود دارد. همانظور که می دانیم استخراج داده ها در پشته به این ترتیب است که **آخرین داده وارد شده اول استخراج می شود** و به همین صورت تا اولین داده پیش می رود. ضمنا متدهایی مختص استثناها وجود دارد که نمونه ای رایج از آنها **printStackTrace** جهت نمایش داده های پشته در خروجی است. همچنین استفاده از **چند بلاک catch** و تعریف **چند استثناء** هم ممکن است.


## بررسی و نمایش مقدار ورودی Assertion


از جمله عبارات کاربردی در زبان جاوا **Assert** می باشد که وظیفه **بررسی و نمایش ورودی دریافت شده از کاربر** را از طریق **شروط** تعیین شده در داخل آن و سپس **نمایش** آن ورودی یا پیام خطا را بر عهده دارد.
                                                                           
assert( number >= 0 && number <= 10 ) : " bad number " + number;





