

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
