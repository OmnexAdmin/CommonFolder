set ProjectPath=D:\OSSGit\CommonFolder\EwQIMS_POM
cd %ProjectPath%
set classpath=%ProjectPath%\target\classes;%ProjectPath%\lib\*
java org.testng.TestNG %ProjectPath%\testng.xml
pause


