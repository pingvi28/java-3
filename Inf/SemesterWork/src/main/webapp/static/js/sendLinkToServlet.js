document.addEventListener('DOMContentLoaded', function () {
    $(document).ready(function () {
        $('.bxVideoFrame').click(function() {
            let link= $(this).attr('scr');
            alert(link)
        });
    });
});
