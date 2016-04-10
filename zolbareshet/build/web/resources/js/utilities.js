

function dateFormat(oi)
{
    if (document.getElementById) {
        var dm = document.getElementById(oi);
        var e = dm.value;
        var l = e.length;

        if (l == 2 || l == 5) {
            dm.value = e +"/";
        }

    }
}
function setClockAndMessage(){
    if (document.getElementById) {
        var dm3 = document.getElementById("loginusername");
        username=dm3.value;
        var currentdate=new Date();
        if(dm3 && username) {
            var dm4 = document.getElementById("loginMessage");
            dm4.innerHTML = formatMessage(currentdate.getHours()) + " " + username;
        }
        setInterval(function() {
            currentdate=new Date();
            var dm = document.getElementById("clock");
            var datetime = currentdate.getDay() + "/"+currentdate.getMonth()
                + "/" + currentdate.getFullYear() + " \n "
                + currentdate.getHours() + ":"
                + currentdate.getMinutes() + ":" + currentdate.getSeconds();
            dm.innerHTML =datetime;
        },1000)
    }
    
}

function formatMessage(hour) {
    var res;
    if(hour>6 && hour<12){
        res="GoodMorning";
    }
    else if(hour>12 && hour<18){
        res="Good AfterNoon";
    }
    else if (hour>18 && hour<23){
        res="Good Evening";
    }
    else{
        res="Good Night";
    }
    return res;
}
 
function loadUserFields(){
    setField("nickname","nickname-param"); /*setField("phone2-per-param");*/
    setField("firstname-param");/* setField("phone2-num-param");*/
    setField("lastname-param"); /*setField("phone2-type-param");*/
    setField("password","password-param"); /*setField("phone3-per-param");*/
    setField("mailaddress","email-param"); /*setField("phone3-num-param");*/
    setField("role","role-param"); /*setField("phone3-type-param");*/
   /* setField("phone1-per-param"); setField("phone4-per-param");
    setField("phone1-num-param"); setField("phone4-num-param");
    setField("phone1-type-param");  setField("phone4-type-param");
*/



}

function setField(field,value){
    var dm = document.getElementById(field);
    dm.value=value;
}

function getRequestParam(param){
    var dm = document.getElementById(param);
   return dm.value;   
}
