

function pw() {return window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth};
function mouseX(evt) {return evt.clientX ? evt.clientX + (document.documentElement.scrollLeft || document.body.scrollLeft) : evt.pageX;}
function mouseY(evt) {return evt.clientY ? evt.clientY + (document.documentElement.scrollTop || document.body.scrollTop) : evt.pageY}
function popUp(evt,oi)
{if (document.getElementById) {
    var wp = pw();
    dm = document.getElementById(oi);
    ds = dm.style; st = ds.visibility;
    if (dm.offsetWidth) ew = dm.offsetWidth;
    else if (dm.clip.width) ew = dm.clip.width;
    if (st == "visible" || st == "show") {
        ds.visibility = "hidden"; }
    else {tv = mouseY(evt) ;
        lv = mouseX(evt) - (ew/4);
        if (lv < 2) lv = 2;
        else if (lv + ew > wp) lv -= ew/2;
        lv += "px";tv += "px";
        ds.left = lv; ds.top = tv;
        ds.visibility = "visible";}}}

function myFunction(selection) {
    if (selection == 1) {
        document.getElementById("test:myText").style.display = "";
        document.getElementById("test:mySelectMenu").style.display = "none";
    } else {
        document.getElementById("test:myText").style.display = "none";
        document.getElementById("test:mySelectMenu").style.display = "";
    }
}
    function showhide(event,v1,v2,v3){

        var checkbox=event.target;
        if (checkbox.checked){
            alert("jhjyf");
            setVisible(v1);
            setVisible(v2);
            setVisible(v3);

        }
        else{
            setHidden(v1);
            setHidden(v2);
            setHidden(v3);
        }
        function setVisible (id){
           dm = document.getElementById(id);
            dm.styleclass="visible";
        }
        function setHidden (id){
            dm = document.getElementById(id);
            dm.styleclass="hidden";
        }
}

function showMe (box) {

    var chboxs = document.getElementsByName("c1");
    var vis = "none";
    for(var i=0;i<chboxs.length;i++) {
        if(chboxs[i].checked){
            vis = "block";
            break;
        }
    }
    var dm = document.getElementById(box);
    dm.style.display = vis;
}

function showhide2(obj,id) {


    document.getElementById(id).style.display = (obj.checked ? '' : 'none');
}