document.addEventListener('DOMContentLoaded', function () {
    // Get the modal
    modal = document.getElementById('id01');

    window.onclick = function(event) {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    }
});

