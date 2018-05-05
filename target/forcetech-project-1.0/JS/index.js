//noinspection JSAnnotator
/**
 * Created by CristyBv on 01-Apr-18.
 */

window.onload = function(){
    if(errorLogin) alert(errorLogin); //daca errorLogin != NULL
    var myIndex = 0;
    carousel();

    function carousel() {
        var i;
        var x = document.getElementsByClassName("mySlides");
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        myIndex++;
        if (myIndex > x.length) {myIndex = 1;}
        x[myIndex-1].style.display = "block";
        setTimeout(carousel, 2000);
    }




}