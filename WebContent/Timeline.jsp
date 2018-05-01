<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
   <link rel="stylesheet" href="script/jqwidget/styles/jqx.base.css" type="text/css" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1 minimum-scale=1" />	
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
    var appointments = new Array();

    var appointment1 = {
        id: "id1",
        description: "George brings projector for presentations.",
        location: "",
        subject: "Quarterly Project Review Meeting",
        calendar: "Room 1",
        start: new Date(2015, 10, 23, 9, 0, 0),
        end: new Date(2015, 10, 23, 16, 0, 0)
    }

    var appointment2 = {
        id: "id2",
        description: "",
        location: "",
        subject: "IT Group Mtg.",
        calendar: "Room 2",
        start: new Date(2015, 10, 24, 10, 0, 0),
        end: new Date(2015, 10, 24, 15, 0, 0)
    }

    var appointment3 = {
        id: "id3",
        description: "",
        location: "",
        subject: "Course Social Media",
        calendar: "Room 3",
        start: new Date(2015, 10, 27, 11, 0, 0),
        end: new Date(2015, 10, 27, 13, 0, 0)
    }

    var appointment4 = {
        id: "id4",
        description: "",
        location: "",
        subject: "New Projects Planning",
        calendar: "Room 2",
        start: new Date(2015, 10, 23, 16, 0, 0),
        end: new Date(2015, 10, 23, 18, 0, 0)
    }

    var appointment5 = {
        id: "id5",
        description: "",
        location: "",
        subject: "Interview with James",
        calendar: "Room 1",
        start: new Date(2015, 10, 25, 15, 0, 0),
        end: new Date(2015, 10, 25, 17, 0, 0)
    }

    var appointment6 = {
        id: "id6",
        description: "",
        location: "",
        subject: "Interview with Nancy",
        calendar: "Room 4",
        start: new Date(2015, 10, 26, 14, 0, 0),
        end: new Date(2015, 10, 26, 16, 0, 0)
    }
    appointments.push(appointment1);
    appointments.push(appointment2);
    appointments.push(appointment3);
    appointments.push(appointment4);
    appointments.push(appointment5);
    appointments.push(appointment6);


    // prepare the data
    var source =
    {
        dataType: "array",
        dataFields: [
            { name: 'id', type: 'string' },
            { name: 'description', type: 'string' },
            { name: 'location', type: 'string' },
            { name: 'subject', type: 'string' },
            { name: 'calendar', type: 'string' },
            { name: 'start', type: 'date' },
            { name: 'end', type: 'date' }
        ],
        id: 'id',
        localData: appointments
    };
    var adapter = new $.jqx.dataAdapter(source);
    $("#scheduler").on('bindingComplete', function (event) {
        var args = event.args;
        console.log("bindingComplete is raised");
    });

    $("#scheduler").jqxScheduler({
        date: new $.jqx.date(2015, 11, 23),
        width: 850,
        height: 600,
        source: adapter,
        showLegend: false,
        ready: function () {
            $("#scheduler").jqxScheduler('ensureAppointmentVisible', 'id1');
        },
        resources:
        {
            colorScheme: "scheme05",
            dataField: "calendar",
            source:  new $.jqx.dataAdapter(source)
        },
        appointmentDataFields:
        {
            from: "start",
            to: "end",
            id: "id",
            description: "description",
            location: "place",
            subject: "subject",
            resourceId: "calendar"
        },
        view: 'weekView',
        views:
        [
            'dayView',
            'weekView',
            'monthView'
        ]
    });
          

            $("#scheduler").on('appointmentChange', function (event) {
                var args = event.args;
                var appointment = args.appointment;
                var subject = args.subject;
                var to = args.to;
                var date = args.date;
                // appointment fields
                // originalData - the bound data.
                // from - jqxDate object which returns when appointment starts.
                // to - jqxDate objet which returns when appointment ends.
                // status - String which returns the appointment's status("busy", "tentative", "outOfOffice", "free", "").
                // resourceId - String which returns the appointment's resouzeId
                // hidden - Boolean which returns whether the appointment is visible.
                // allDay - Boolean which returns whether the appointment is allDay Appointment.
                // resiable - Boolean which returns whether the appointment is resiable Appointment.
                // draggable - Boolean which returns whether the appointment is resiable Appointment.
                // id - String or Number which returns the appointment's ID.
                // subject - String which returns the appointment's subject.
                // location - String which returns the appointment's location.
                // description - String which returns the appointment's description.
                // tooltip - String which returns the appointment's tooltip.
               $.ajax({
                url: 'appointments',
                type: 'POST',        
                dataType: 'json',
                contentType: 'application/x-www-form-urlencoded; charset=UTF-8',

                data: {id: 5},
                success: function(data) {
                    console.log(data);
                }
            });
 
                alert("message: "  );
                
            });    
            
              
});

</script>
</head>
<body>
<div id="scheduler">
         
        </div>
</body>
</html>