$(document).ready(function(){
    // click on button submit
    $(".btn").on('click', function(event){
        event.preventDefault();
        var formData = JSON.stringify($("#publisherForm").serializeArray());        
        $.ajax({
            type: "POST",
            url: "/publishers",
            data: formData,
            success: function(formData){
                console.log(formData);
            },
            error: function() {
                alert("did not send");
            },
            dataType: "json",
            contentType : "application/json"
          });     
        
       
    });
});