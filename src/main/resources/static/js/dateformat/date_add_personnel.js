///////////////////////////////////////////////////////////////////////////////////
// BIRTHDATE
///////////////////////////////////////////////////////////////////////////////////

const display = document.getElementById("formatteddate");
const hidden = document.getElementById("birthdate");
const error = document.getElementById("dateError");

const months = [
    "Jan",
    "Feb",
    "Mar",
    "Apr",
    "May",
    "Jun",
    "Jul",
    "Aug",
    "Sep",
    "Oct",
    "Nov",
    "Dec"
];


// Show existing birthdate
if (hidden && hidden.value) {

    let [year, month, day] =
        hidden.value.split("-");

    let mon =
        months[Number(month) - 1];

    display.value =
        `${day}-${mon}-${year}`;
}


display.addEventListener("input", function () {

    error.style.display = "none";

    display.classList.remove("date-invalid");


    // Keep only letters and numbers
    let raw =
        display.value.replace(/[^a-zA-Z0-9]/g, "");


    let day =
        raw.slice(0, 2);

    let mon =
        raw.slice(2, 5);

    let year =
        raw.slice(5, 9);


    // Build DD-MMM-YYYY
    let formatted = "";

    if (day)
        formatted += day;

    if (mon)
        formatted += "-" + mon;

    if (year)
        formatted += "-" + year;


    display.value = formatted;


    // Find month
    let monthIndex =
        months.findIndex(
            m =>
                m.toLowerCase() ===
                mon.toLowerCase()
        );


    // Basic validation
    let isValid =
        day.length === 2 &&
        monthIndex >= 0 &&
        year.length === 4 &&
        Number(day) >= 1 &&
        Number(day) <= 31;


    if (isValid) {

        let mm =
            String(monthIndex + 1)
                .padStart(2, "0");


        hidden.value =
            `${year}-${mm}-${day}`;


        // Hide error
        error.style.display = "none";

        display.classList.remove("date-invalid");


        // REAL-TIME UPDATE
        if (typeof calculateDate === "function") {
            calculateDate();
        }


    } else {

        hidden.value = "";


        // Clear compulsory retirement
        const retirement =
            document.getElementById(
                "compulsoryRetirement"
            );

        if (retirement) {
            retirement.value = "";
        }


        /*
         * Show error when input is complete
         */
        if (formatted.length === 11) {

            error.textContent =
                "Invalid date format. Use DD-MMM-YYYY.";

            error.style.display = "block";

            display.classList.add("date-invalid");

        }

    }

});



///////////////////////////////////////////////////////////////////////////////////
// ENTERED MILITARY SERVICE
///////////////////////////////////////////////////////////////////////////////////

const formattedMilitaryServiceDate =
    document.getElementById(
        "dateEnterMilitaryServiceFormatted"
    );

const militaryServiceDate =
    document.getElementById(
        "dateEnterMilitaryService"
    );

const militaryServiceDateError =
    document.getElementById(
        "dateErrorEnterMilitaryService"
    );


const monthsMilitaryServiceDate = [
    "Jan",
    "Feb",
    "Mar",
    "Apr",
    "May",
    "Jun",
    "Jul",
    "Aug",
    "Sep",
    "Oct",
    "Nov",
    "Dec"
];


// Show existing military service date
if (
    militaryServiceDate &&
    militaryServiceDate.value
) {

    let [year, month, day] =
        militaryServiceDate.value.split("-");

    let mon =
        monthsMilitaryServiceDate[
            Number(month) - 1
        ];

    formattedMilitaryServiceDate.value =
        `${day}-${mon}-${year}`;
}


formattedMilitaryServiceDate.addEventListener(
    "input",
    function () {

        militaryServiceDateError.style.display =
            "none";

        formattedMilitaryServiceDate.classList.remove(
            "date-invalid"
        );


        // Keep only letters and numbers
        let raw =
            formattedMilitaryServiceDate.value
                .replace(/[^a-zA-Z0-9]/g, "");


        let day =
            raw.slice(0, 2);

        let mon =
            raw.slice(2, 5);

        let year =
            raw.slice(5, 9);


        // Build DD-MMM-YYYY
        let formatted = "";

        if (day)
            formatted += day;

        if (mon)
            formatted += "-" + mon;

        if (year)
            formatted += "-" + year;


        formattedMilitaryServiceDate.value =
            formatted;


        // Find month
        let monthIndex =
            monthsMilitaryServiceDate.findIndex(
                m =>
                    m.toLowerCase() ===
                    mon.toLowerCase()
            );


        // Validate
        let isValid =
            day.length === 2 &&
            monthIndex >= 0 &&
            year.length === 4 &&
            Number(day) >= 1 &&
            Number(day) <= 31;


        if (isValid) {

            let mm =
                String(monthIndex + 1)
                    .padStart(2, "0");


            militaryServiceDate.value =
                `${year}-${mm}-${day}`;


            militaryServiceDateError.style.display =
                "none";


            formattedMilitaryServiceDate.classList.remove(
                "date-invalid"
            );


        } else {

            militaryServiceDate.value = "";


            /*
             * Show error when complete
             */
            if (formatted.length === 11) {

                militaryServiceDateError.textContent =
                    "Invalid date format. Use DD-MMM-YYYY.";

                militaryServiceDateError.style.display =
                    "block";

                formattedMilitaryServiceDate.classList.add(
                    "date-invalid"
                );

            }

        }

    }
);