/**
 * Created by CristyBv on 31-Mar-18.
 */

window.onload = function(){
    var img=document.getElementById("avatarimg");
    img.src=avatar;
    var imag=document.getElementsByName("avatar")[0];
    if(avatar!="IMG/noavatar.png") imag.value=avatar;
    var firstname=document.getElementsByName("firstname")[0];
    firstname.value=nume;
    var lastname=document.getElementsByName("lastname")[0];
    lastname.value=prenume;
    var mail=document.getElementsByName("email")[0];
    mail.value=email;
    var sexx=document.getElementsByName("sex");
    if(sex=="feminin") sexx[1].checked=true;
    var varstaa=document.getElementsByName("varsta")[0];
    varstaa.value=varsta;
    var inaltimee=document.getElementsByName("inaltime")[0];
    inaltimee.value=inaltime;
    var greutatee=document.getElementsByName("greutate")[0];
    greutatee.value=greutate;
    var nivactt=document.getElementsByName("nivelact")[0];
    var opt=nivactt.options;
    for(var i=0;i<opt.length;i++)
        if(opt[i].value==nivelact) opt[i].selected=true;
    var tipactt=document.getElementsByName("tipact");
    var str=tipact.split('/');
    for(var i=0;i<str.length;i++){
        if(str[i]=="alergat") tipactt[0].checked=true;
        if(str[i]=="static") tipactt[1].checked=true;
        if(str[i]=="workout") tipactt[2].checked=true;
        if(str[i]=="sports") tipactt[3].checked=true;
    }
    var feed=document.getElementsByName("feedback")[0];
    if(feedback!="") feed.value=feedback;
    if(error=="1"){
        var errors="";
        if(notsamepass) errors+=notsamepass+"\n";
        if(notoldpass) errors+=notoldpass+"\n";
        if(notcorrectoldpass) errors+=notcorrectoldpass+"\n";
        alert(errors);
    }
    if(succes) { alert(succes); window.location="/profile.jsp"; }

}