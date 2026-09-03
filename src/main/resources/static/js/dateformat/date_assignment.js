///////////////////////////////////////////////////////////////////////////////////
const display = document.getElementById("dateassignedFormatted");
const hidden  = document.getElementById("dateassigned");
const error   = document.getElementById("dateErrordateassigned");

const months = ["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];

// ✅ If hidden dateassigned has a value, display it in dateassignedFormatted
if (hidden.value) {
    let [year, month, day] = hidden.value.split("-"); // YYYY-MM-DD
    let mon = months[Number(month) - 1];
    display.value = `${day}${mon ? '-' + mon : ''}${year ? '-' + year : ''}`;
}

display.addEventListener("input", () => {
    error.style.display = "none";

    // Keep only letters & numbers
    let raw = display.value.replace(/[^a-zA-Z0-9]/g, "");

    let day  = raw.slice(0, 2);
    let mon  = raw.slice(2, 5);
    let year = raw.slice(5, 9);

    // Build formatted value
    let formatted = "";
    if (day) formatted += day;
    if (mon) formatted += "-" + mon;
    if (year) formatted += "-" + year;

    display.value = formatted;

    // Validate month
    let monthIndex = months.findIndex(
        m => m.toLowerCase() === mon.toLowerCase()
    );

    let isValid =
        day.length === 2 &&
        monthIndex >= 0 &&
        year.length === 4 &&
        Number(day) >= 1 &&
        Number(day) <= 31;

    if (isValid) {
        let mm = String(monthIndex + 1).padStart(2, "0");
        hidden.value = `${year}-${mm}-${day}`;

        // calculateDate(); // ❌ removed (not related to dateassigned)
        error.style.display = "none";
    } else {
        hidden.value = "";

        if (formatted.length === 11) {
            error.style.display = "block";
        }
    }
});



/////////////////////////////////////////////////////////////////////////////////////////////////////////
const formattedDateAssumeBillet = document.getElementById("dateassumebilletFormatted");
const dateAssumeBillet = document.getElementById("dateassumebillet");
const dateAssumeBilletError = document.getElementById("dateErrordateassumebillet");

const monthsDateAssumeBillet = ["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];

// ✅ Show existing date in a readable format
if (dateAssumeBillet.value) {
    let [year, month, day] = dateAssumeBillet.value.split("-"); // YYYY-MM-DD
    let mon = monthsDateAssumeBillet[Number(month) - 1];
    formattedDateAssumeBillet.value = `${day}${mon ? '-' + mon : ''}${year ? '-' + year : ''}`;
}

formattedDateAssumeBillet.addEventListener("input", () => {
    dateAssumeBilletError.style.display = "none";

    // Keep only letters & numbers
    let raw = formattedDateAssumeBillet.value.replace(/[^a-zA-Z0-9]/g, "");

    let day  = raw.slice(0, 2);
    let mon  = raw.slice(2, 5);
    let year = raw.slice(5, 9);

    // Build formatted value
    let formatted = "";
    if (day) formatted += day;
    if (mon) formatted += "-" + mon;
    if (year) formatted += "-" + year;

    formattedDateAssumeBillet.value = formatted;

    // Validate month
    let monthIndex = monthsDateAssumeBillet.findIndex(
        m => m.toLowerCase() === mon.toLowerCase()
    );

    let isValid =
        day.length === 2 &&
        monthIndex >= 0 &&
        year.length === 4 &&
        Number(day) >= 1 &&
        Number(day) <= 31;

    if (isValid) {
        let mm = String(monthIndex + 1).padStart(2, "0");
        dateAssumeBillet.value = `${year}-${mm}-${day}`;
        dateAssumeBilletError.style.display = "none";
    } else {
        dateAssumeBillet.value = "";

        if (formatted.length === 11) {
            dateAssumeBilletError.style.display = "block";
        }
    }
});



////////////////////////////////////////////////////////////////////////////////////////////////
const formattedDateRelieve = document.getElementById("daterelieveFormatted");
const dateRelieve = document.getElementById("daterelieve");
const dateRelieveError = document.getElementById("dateErrordaterelieve");

const monthsDateRelieve = ["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];

// ✅ Show existing date in a readable format
if (dateRelieve.value) {
    let [year, month, day] = dateRelieve.value.split("-"); // YYYY-MM-DD
    let mon = monthsDateRelieve[Number(month) - 1];
    formattedDateRelieve.value = `${day}${mon ? '-' + mon : ''}${year ? '-' + year : ''}`;
}

formattedDateRelieve.addEventListener("input", () => {
    dateRelieveError.style.display = "none";

    // Keep only letters & numbers
    let raw = formattedDateRelieve.value.replace(/[^a-zA-Z0-9]/g, "");

    let day  = raw.slice(0, 2);
    let mon  = raw.slice(2, 5);
    let year = raw.slice(5, 9);

    // Build formatted value
    let formatted = "";
    if (day) formatted += day;
    if (mon) formatted += "-" + mon;
    if (year) formatted += "-" + year;

    formattedDateRelieve.value = formatted;

    // Validate month
    let monthIndex = monthsDateRelieve.findIndex(
        m => m.toLowerCase() === mon.toLowerCase()
    );

    let isValid =
        day.length === 2 &&
        monthIndex >= 0 &&
        year.length === 4 &&
        Number(day) >= 1 &&
        Number(day) <= 31;

    if (isValid) {
        let mm = String(monthIndex + 1).padStart(2, "0");
        dateRelieve.value = `${year}-${mm}-${day}`;
        dateRelieveError.style.display = "none";
    } else {
        dateRelieve.value = "";

        if (formatted.length === 11) {
            dateRelieveError.style.display = "block";
        }
    }
});
