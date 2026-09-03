
    (function() {
        document.addEventListener('contextmenu', event => event.preventDefault());
        document.addEventListener('keydown', event => {
            if (event.key === "F12" || 
                (event.ctrlKey && event.shiftKey && (event.key === "I" || event.key === "J")) || 
                (event.ctrlKey && event.key === "U")) {
                event.preventDefault();
            }
        });
        setInterval(function() {
            let devtools = /./;
            devtools.toString = function() {
                throw new Error("DevTools detected!");
            };
            console.log('%c', devtools);
        }, 15 * 60 * 1000);

        })(); 

