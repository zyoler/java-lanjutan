$(document).ready(function () {
    $("form").submit(function (event) {
        event.preventDefault();

        const body = {
            "email" : $("input[name=email]").val(),
            "password" : $("input[name=password]").val()
        }

        $.post({
            url: "/Rest-data/do-login",
            contentType : "application/JSON",
            data : JSON.stringify(body) + {email:email},
            method:'POST',
            success : function (response) {
                console.log("Berhasil atuh",response);
                console.log(response.message);
                console.log(response.responseCode);
                $("#berhasil").removeClass("is-hidden");
                $("#gagal").addClass("is-hidden");
                window.location = "/dashboard";
            },
            error : function (response) {
                console.log("Gagal Boss",response);
                console.log(response.responseJSON.message);
                console.log(response.responseJSON.responseCode);

                $("#gagal").removeClass("is-hidden");
                $("#berhasil").addClass("is-hidden");
                console.log($("#gagal"));
            }
        });
    })
})

// document.addEventListener('DOMContentLoaded', () => {
//     (document.querySelectorAll('.notification .delete') || []).forEach(($delete) => {
//         const $notification = $delete.parentNode.attributes['1'].value;
//
//         $delete.addEventListener('click', () => {
//             // $notification.parentNode.removeChild($notification);
//             const name = "#" + $notification;
//             $(name).addClass("is-hidden");
//         });
//     });
// });