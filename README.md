hive-UDxF-collectors
====================

hive UDF/UDAF/UDTF collectors

#各种平常用到的hive udf udaf udtf的集合

## 函数列表

* UDFDateformatAtStr
进行时间类型的转换，函数名dateformatatatr参数1=要进行转换的文本,参数2=要得到的时间格式,参数3=输入的文本的时间格式,参数4=时区格式(us,cn等)
dateformatatatr(time,'yyyy-MM-dd','dd/MMM/yyyy:HH:mm:ss Z','us')
会把01/Nov/2012:23:59:57 +0800样式的时间转换为yyyy-MM-dd格式