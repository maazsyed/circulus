$(document).ready(function(){
   setInterval(function() {
$("input[type=text]").each(function() {
   var element = $(this);
   if (element.val() !== "") {
     $(this).css({
       boxShadow: 'inset 8px 0px 0  #2ecc71',
       paddingLeft: '12px'})
   }
   var element = $(this);
   if (element.val() == "") {
       $(this).css('border-left', '1px solid #ccc')
   }
});  
}, 200);
});  