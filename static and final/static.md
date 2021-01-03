﻿## static

**تعریف**
این کلیدواژه غالبا برای مدیریت حافظه به کار میرود و میتوان این کلید واژه را برروی 
متغیرها،متدها،قطعه کد و کلاس های تو در تو اعمال کرد.

**متغیر های static**

این کلیدواژه برروی خود کلاس اعمال میشود نه نمونه های ساخته شده از آن،به عنوان مثال متغیری که static تعریف شده میتواند بدون ساختن نمونه از شئ مذکور فراخوانی شود و بین تمامی نمونه های ساخنه شده از کلاس مشترک است(با مقدار مشترک(
وقتی یک متغیر static تعریف میشود،این متغیر بین تمامی نمونه های ساخته شده از آن کلاس مشترک است و مثل یک متغیر های ساخته شده هر شئ نمیباشد به شکلی که برای دسترسی به آن نیازی به ساختن یک شئ از کلاس نیست

**متد های static**

*کاربردر ها*

 - یک متد static به کل کلاس میزبان تعلق دارد و مستقل از نمونه های ساخته شده از یک کلاس است
 - این متد ها را میتوان بدون ساختن یک نمونه از کلاسی که به آن تعلق دارد فراخوانی کرد
 - متد های static به متغیر های static دسترسی داشته و میتوانند آنها را تغییر دهند


*محدودیت های متد های static*
 - متدهای static قابلیت دسترسی به متغیرهای static را ندارند 
 - در این متدها نمیتوان از کلیدواژه های super , this  استفاده کرد


**قطعه کد static**
 - برای مقداردهی متغیر های static استفاده میشود
 - قبل از متد main در زمان بارگزاری کلاس در حافظه اجرا میشود.
