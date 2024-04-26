Project Setup Guide for Backend in IntelliJ

Double check if you have the table "Employee" in your database.

CREATE TABLE EMPLOYEE (
    LAST_NAME           VARCHAR2(64)NOT NULL,
    FIRST_NAME          VARCHAR2(64)NOT NULL,
    MIDDLE_NAME         VARCHAR2(64)NOT NULL,
    POSITION_IN_RC      VARCHAR2(64),
    DATE_EMPLOYED       TIMESTAMP(6),
    BIRTHDATE           TIMESTAMP(6),
    BIRTHPLACE          VARCHAR2(64),
    SEX                 VARCHAR2(8),
    CIVIL_STATUS        VARCHAR2(32),
    CITIZENSHIP         VARCHAR2(32),
    RELIGION            VARCHAR2(32),
    HEIGHT              NUMBER(8),
    WEIGHT              NUMBER(8),
    EMAIL               VARCHAR2(64),
    SSS_NO              VARCHAR2(16),
    TIN_NO              VARCHAR2(16),
    PAGIBIG_NO          VARCHAR2(16),	
    EMPLOYEE_NO         VARCHAR2(16),
    PRIMARY KEY (EMPLOYEE_NO));


Setting Up Project Settings

Open the project, click on `File` and look for `Settings`.After opening the project and navigating to File, click on Settings.
![image](https://github.com/RoCS2024/rc-ums/assets/155501148/45c2e958-4dc0-4d42-b2d6-df1ddbb6ff18)


Once in the settings, locate the Build, Execution, Deployment section. Then, find the Build Tools option and change it to Any Changes. Remember to click Apply at the button, followed by OK.
![image](https://github.com/RoCS2024/rc-ums/assets/155501148/305d42b2-cf6c-4f00-8be3-e3602390909c)


Next is Setting Up IvyIDEA

First step, you need to install IvyIDEA first. Double click “Shift“ in your keyboard and this will pop up. If you already have IvyIDEA in your intellij, please skip steps 1 to 3.

![image](https://github.com/RoCS2024/rc-ums/assets/155501148/a3b507b3-5a7b-49a3-ae11-129c824e0a6c)


Once it pops up, type the word “plugin“ and click the third option.
![image](https://github.com/RoCS2024/rc-ums/assets/155501148/4484881f-db2c-4c83-89d9-84c43750dd9c)

After clicking the third option, type “ivIDEA“ and install it. (In my case I have already installed it) 
![image](https://github.com/RoCS2024/rc-ums/assets/155501148/c63aaeac-c5a7-4644-8584-54833c6d804f)

Once you have installed it, go to project structure and click modules. 
![image](https://github.com/RoCS2024/rc-ums/assets/155501148/22d8d60b-d5fa-49d5-a178-619501826796)


Next step, you will click the folder of your project and click the “plus sign“ button on the top then choose the ivyIDEA. 
![image](https://github.com/RoCS2024/rc-ums/assets/155501148/785ba65a-d950-412f-9385-c628a8a8a22d)
![image](https://github.com/RoCS2024/rc-ums/assets/155501148/6c308cfc-c68b-4933-904c-367864966ee0)


Once you have it, click the folder button here and choose the directory of your “ivy.xml” file.
![image](https://github.com/RoCS2024/rc-ums/assets/155501148/90177acb-988d-4920-8c23-eb4682e5c09d)

![image](https://github.com/RoCS2024/rc-ums/assets/155501148/38528460-277b-452b-a3b7-0e7d710f2302)
Once you are done, on the bottom part you will check the “Use module specific ivy settings“ and then choose the “Use ivy default“. Click apply then ok.

![image](https://github.com/RoCS2024/rc-ums/assets/155501148/8da07982-6a8a-41ca-b3b0-57ae7623ea5b)
Also please make sure that in project settings, you have done this. 


Once you have done all of the steps above, right click the folder of your project and at the bottom you will see an option “IvyIDEA“ go to that option and another options will pop up. Choose the first one.
![image](https://github.com/RoCS2024/rc-ums/assets/155501148/ee745d3a-993b-406a-92ef-6562c1db7812)


After clicking it, a folder of ivyIDEA should appear under External Libraries.
![image](https://github.com/RoCS2024/rc-ums/assets/155501148/313c6f3d-61af-4da6-8668-dfb50b06c7d6)

Once done, you will fix the errors. Click alt+enter and choose “Add ivyIDEA to classpath“. And you are done.
![image](https://github.com/RoCS2024/rc-ums/assets/155501148/07c7bd73-1a7d-4242-bcc9-984b4a4fcc58)


Marking the Root Type of Packages

First Right-click on the java folder in your project.
Select Mark Directory as > 'Sources Root'.
![image](https://github.com/RoCS2024/rc-ums/assets/155501148/63e69422-2e2d-47e7-861a-7957f44c6d32)

Then Right-click on the resource folder in your project.
Select Mark Directory as > 'Resources Root'.
![image](https://github.com/RoCS2024/rc-ums/assets/155501148/91f21d41-4136-4974-bafe-344916281d2a)

Last Right-click on the test java folder in your project.
Select Mark Directory as > 'Test Sources Root'.
![image](https://github.com/RoCS2024/rc-ums/assets/155501148/02cf2f93-6345-47fc-97f0-74f8d7a25828)



When an error like this occurs, go to File > Project Structure.
![Screenshot (319)](https://github.com/RoCS2024/rc-ums/assets/155501148/68b633d7-8422-49d7-b4bf-4dc6b996f235)

Under Project, select the correct JDK from the Project SDK dropdown. Click apply then ok.
![Screenshot (320)](https://github.com/RoCS2024/rc-ums/assets/155501148/64e31409-1ac3-411c-99ca-0415f06593bd)


If you encountered errors like these in Logging and you've successfully added the import, but it's still not working, 
![image](https://github.com/RoCS2024/rc-ums/assets/155501148/78f068ac-f2af-41f1-a969-f6f34530fe1b)

Go to file explorer, Cllok on the Local Disk (C), then navigate to the users
![image](https://github.com/RoCS2024/rc-ums/assets/155501148/b7d2e9cb-2850-454a-91dc-aacccb1f2caf)

Find the .ivy2
![image](https://github.com/RoCS2024/rc-ums/assets/155501148/f43f3f94-5fc5-4a93-9794-ab670948e02e)

Then look for the org.apache.logging.log4j. Click it 
![image](https://github.com/RoCS2024/rc-ums/assets/155501148/712913a5-9c76-4bd6-93b2-2ca30387dc03)


And delete the log4j-to-slf4j
![image](https://github.com/RoCS2024/rc-ums/assets/155501148/323bb84a-41f2-46f6-8615-60d99387f55e)

Go back to our project and refresh it and it's done. 



