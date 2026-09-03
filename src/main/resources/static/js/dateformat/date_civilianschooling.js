const formattedStartSchoolYear = document.getElementById("startschoolyearFormatted");
const startSchoolYear = document.getElementById("startschoolyear");
const startSchoolYearError = document.getElementById("dateErrorstartschoolyear");

const monthsStartSchoolYear = [
    "Jan","Feb","Mar","Apr","May","Jun",
    "Jul","Aug","Sep","Oct","Nov","Dec"
];

// ✅ Show existing date in a readable format
if (startSchoolYear.value) {
    let [year, month, day] = startSchoolYear.value.split("-"); // YYYY-MM-DD
    let mon = monthsStartSchoolYear[Number(month) - 1];
    formattedStartSchoolYear.value =
        `${day}${mon ? '-' + mon : ''}${year ? '-' + year : ''}`;
}

formattedStartSchoolYear.addEventListener("input", () => {
    startSchoolYearError.style.display = "none";

    // Keep only letters & numbers
    let raw = formattedStartSchoolYear.value.replace(/[^a-zA-Z0-9]/g, "");

    let day  = raw.slice(0, 2);
    let mon  = raw.slice(2, 5);
    let year = raw.slice(5, 9);

    // Build formatted value
    let formatted = "";
    if (day) formatted += day;
    if (mon) formatted += "-" + mon;
    if (year) formatted += "-" + year;

    formattedStartSchoolYear.value = formatted;

    // Validate month
    let monthIndex = monthsStartSchoolYear.findIndex(
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
        startSchoolYear.value = `${year}-${mm}-${day}`;
        startSchoolYearError.style.display = "none";
    } else {
        startSchoolYear.value = "";

        if (formatted.length === 11) {
            startSchoolYearError.style.display = "block";
        }
    }
});




///////////////////////////////////////////////////////////////////////////////////////////


const formattedEndSchoolYear = document.getElementById("endschoolyearFormatted");
const endSchoolYear = document.getElementById("endschoolyear");
const endSchoolYearError = document.getElementById("dateErrorendschoolyear");

const monthsEndSchoolYear = [
    "Jan","Feb","Mar","Apr","May","Jun",
    "Jul","Aug","Sep","Oct","Nov","Dec"
];

// ✅ Show existing date in a readable format
if (endSchoolYear.value) {
    let [year, month, day] = endSchoolYear.value.split("-"); // YYYY-MM-DD
    let mon = monthsEndSchoolYear[Number(month) - 1];
    formattedEndSchoolYear.value =
        `${day}${mon ? '-' + mon : ''}${year ? '-' + year : ''}`;
}

formattedEndSchoolYear.addEventListener("input", () => {
    endSchoolYearError.style.display = "none";

    // Keep only letters & numbers
    let raw = formattedEndSchoolYear.value.replace(/[^a-zA-Z0-9]/g, "");

    let day  = raw.slice(0, 2);
    let mon  = raw.slice(2, 5);
    let year = raw.slice(5, 9);

    // Build formatted value
    let formatted = "";
    if (day) formatted += day;
    if (mon) formatted += "-" + mon;
    if (year) formatted += "-" + year;

    formattedEndSchoolYear.value = formatted;

    // Validate month
    let monthIndex = monthsEndSchoolYear.findIndex(
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
        endSchoolYear.value = `${year}-${mm}-${day}`;
        endSchoolYearError.style.display = "none";
    } else {
        endSchoolYear.value = "";

        if (formatted.length === 11) {
            endSchoolYearError.style.display = "block";
        }
    }
});
