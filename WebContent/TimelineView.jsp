
<!DOCTYPE html>
<html>
<head>
    <title>jqxScheduler Timeline Views example
    </title>
	<meta name="description" content="Javascript Scheduler Timeline views example" /> 
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1 minimum-scale=1" />	
    <link rel="stylesheet" href="css/jqx.base.css" type="text/css" />
 	<script type="text/javascript" src="script/jqwidget/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="script/jqwidget/jqxcore.js"></script>
    <script type="text/javascript" src="script/jqwidget/jqxbuttons.js"></script>
    <script type="text/javascript" src="script/jqwidget/jqxscrollbar.js"></script>
    <script type="text/javascript" src="script/jqwidget/jqxdata.js"></script>
    <script type="text/javascript" src="script/jqwidget/jqxdate.js"></script>
    <script type="text/javascript" src="script/jqwidget/jqxscheduler.js"></script>
    <script type="text/javascript" src="script/jqwidget/jqxscheduler.api.js"></script>
    <script type="text/javascript" src="script/jqwidget/jqxdatetimeinput.js"></script>
    <script type="text/javascript" src="script/jqwidget/jqxmenu.js"></script>
    <script type="text/javascript" src="script/jqwidget/jqxcalendar.js"></script>
    <script type="text/javascript" src="script/jqwidget/jqxtooltip.js"></script>
    <script type="text/javascript" src="script/jqwidget/jqxwindow.js"></script>
    <script type="text/javascript" src="script/jqwidget/jqxcheckbox.js"></script>
    <script type="text/javascript" src="script/jqwidget/jqxlistbox.js"></script>
    <script type="text/javascript" src="script/jqwidget/jqxdropdownlist.js"></script>
    <script type="text/javascript" src="script/jqwidget/jqxnumberinput.js"></script>
    <script type="text/javascript" src="script/jqwidget/jqxradiobutton.js"></script>
    <script type="text/javascript" src="script/jqwidget/jqxinput.js"></script>
    <script type="text/javascript" src="script/jqwidget/globalization/globalize.js"></script>
    <script type="text/javascript" src="script/jqwidget/globalization/globalize.culture.de-DE.js"></script>
    <script type="text/javascript" src="script/jqwidget/demos.js"></script>
    <script type="text/javascript">
        $(document).ready(function () { 
            // prepare the data
            var source =
            {
                dataType: 'json',
                dataFields: [
                    { name: 'id', type: 'string' },
                    { name: 'subject', type: 'string' },
                    { name: 'description', type: 'string' },
                    { name: 'start', type: 'date', format: "yyyy-MM-dd HH:mm" },
                    { name: 'end', type: 'date', format: "yyyy-MM-dd HH:mm" }
                ],
                id: 'id',
                url: 'TestServlet2'
            };
            var adapter = new $.jqx.dataAdapter(source);
            $("#scheduler").jqxScheduler({
                date: new $.jqx.date(2018, 11, 23),
                width: getWidth("Scheduler"),
                height: 600,
                dayNameFormat: "abbr",
                source: adapter,
                showLegend: true,
                renderAppointment: function(data){
               	 if (data.appointment.subject == "Test2") {
               		 data.style = "#447F6E";
                    }
               	 else if (data.appointment.subject == "Test3") {
                     data.style = "#309B46";
                 }
               	return data;
               },
                ready: function () {
                    $("#scheduler").jqxScheduler('ensureAppointmentVisible', 'id1');
                },
                resources:
                {
                    colorScheme: "scheme04",
                    dataField: "calendar",
                    source:  new $.jqx.dataAdapter(source)
                },
                appointmentDataFields:
                {
                    from: "start",
                    to: "end",
                    description: "description",
                    subject: "subject",
                    id: "id"
                },
                view: 'timelineWeekView',
                views:
                [
                    { type: 'timelineDayView', appointmentHeight: 50 },
                    { type: 'timelineWeekView', appointmentHeight: 50 },
                    { type: 'timelineMonthView', appointmentHeight: 50 }
                ]
            });
            
            $.ajax({
                url: 'TestServlet2',
                type: 'POST',        
                dataType: 'json',
                contentType: 'application/x-www-form-urlencoded; charset=UTF-8',

                data: {id: 5, subject: "Hallo"},
                success: function(data) {
                    console.log(data);
                   
                }
                //alert("Hallo");
            });
        
           // $.post("foo",{id:5,subject:"Nikos",description:"Athens", to:"end",from:"start"});
        });
    </script>
</head>
<body class='default'>
    <div id="scheduler"></div>
</body>
</html>