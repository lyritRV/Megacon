<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="script/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="script/common.js"></script>
<script type="text/javascript" src="script/calendar.js"></script>
<script type="text/javascript" src="script/daypilot-all.min.js" ></script>
</head>
<body>
<div id="dps_jquery"></div> 

<script type="text/javascript"> 
var dps = $("#dps_jquery").daypilotScheduler({ 
  backendUrl : '${pageContext.request.contextPath}/dps',
  height: 300, 
  heightSpec: "Max", 
  timeRangeSelectedHandling: "CallBack", 
  days: 7
}); 
</script>
</body>
</html>