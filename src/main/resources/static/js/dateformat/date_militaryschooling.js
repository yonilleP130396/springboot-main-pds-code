const formattedStartDate = document.getElementById("startFormatted");
const startDate = document.getElementById("start");
const startDateError = document.getElementById("dateErrorstart");

const monthsStartDate = [
    "Jan","Feb","Mar","Apr","May","Jun",
    "Jul","Aug","Sep","Oct","Nov","Dec"
];

// ✅ Show existing date in a readable format
if (startDate.value) {
    let [year, month, day] = startDate.value.split("-"); // YYYY-MM-DD
    let mon = monthsStartDate[Number(month) - 1];
    formattedStartDate.value =
        `${day}${mon ? '-' + mon : ''}${year ? '-' + year : ''}`;
}

formattedStartDate.addEventListener("input", () => {
    startDateError.style.display = "none";

    // Keep only letters & numbers
    let raw = formattedStartDate.value.replace(/[^a-zA-Z0-9]/g, "");

    let day  = raw.slice(0, 2);
    let mon  = raw.slice(2, 5);
    let year = raw.slice(5, 9);

    // Build formatted value
    let formatted = "";
    if (day) formatted += day;
    if (mon) formatted += "-" + mon;
    if (year) formatted += "-" + year;

    formattedStartDate.value = formatted;

    // Validate month
    let monthIndex = monthsStartDate.findIndex(
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
        startDate.value = `${year}-${mm}-${day}`;
        startDateError.style.display = "none";
    } else {
        startDate.value = "";

        if (formatted.length === 11) {
            startDateError.style.display = "block";
        }
    }
});



/////////////////////////////////////////////////////////////////////////


const formattedEndDate = document.getElementById("endFormatted");
const endDate = document.getElementById("end");
const endDateError = document.getElementById("dateErrorend");

const monthsEndDate = [
    "Jan","Feb","Mar","Apr","May","Jun",
    "Jul","Aug","Sep","Oct","Nov","Dec"
];

// ✅ Show existing date in a readable format
if (endDate.value) {
    let [year, month, day] = endDate.value.split("-"); // YYYY-MM-DD
    let mon = monthsEndDate[Number(month) - 1];
    formattedEndDate.value =
        `${day}${mon ? '-' + mon : ''}${year ? '-' + year : ''}`;
}

formattedEndDate.addEventListener("input", () => {
    endDateError.style.display = "none";

    // Keep only letters & numbers
    let raw = formattedEndDate.value.replace(/[^a-zA-Z0-9]/g, "");

    let day  = raw.slice(0, 2);
    let mon  = raw.slice(2, 5);
    let year = raw.slice(5, 9);

    // Build formatted value
    let formatted = "";
    if (day) formatted += day;
    if (mon) formatted += "-" + mon;
    if (year) formatted += "-" + year;

    formattedEndDate.value = formatted;

    // Validate month
    let monthIndex = monthsEndDate.findIndex(
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
        endDate.value = `${year}-${mm}-${day}`;
        endDateError.style.display = "none";
    } else {
        endDate.value = "";

        if (formatted.length === 11) {
            endDateError.style.display = "block";
        }
    }
});
