const formattedDateEtadSotReenlistment = document.getElementById(
    "date_etadsotreenlismentFormatted"
);
const dateEtadSotReenlistment = document.getElementById(
    "date_etadsotreenlisment"
);
const dateEtadSotReenlistmentError = document.getElementById(
    "dateErrordate_etadsotreenlisment"
);

const monthsDateEtadSotReenlistment = [
    "Jan","Feb","Mar","Apr","May","Jun",
    "Jul","Aug","Sep","Oct","Nov","Dec"
];

// ✅ Show existing date in a readable format
if (dateEtadSotReenlistment.value) {
    let [year, month, day] = dateEtadSotReenlistment.value.split("-"); // YYYY-MM-DD
    let mon = monthsDateEtadSotReenlistment[Number(month) - 1];
    formattedDateEtadSotReenlistment.value =
        `${day}${mon ? '-' + mon : ''}${year ? '-' + year : ''}`;
}

formattedDateEtadSotReenlistment.addEventListener("input", () => {
    dateEtadSotReenlistmentError.style.display = "none";

    // Keep only letters & numbers
    let raw = formattedDateEtadSotReenlistment.value.replace(/[^a-zA-Z0-9]/g, "");

    let day  = raw.slice(0, 2);
    let mon  = raw.slice(2, 5);
    let year = raw.slice(5, 9);

    // Build formatted value
    let formatted = "";
    if (day) formatted += day;
    if (mon) formatted += "-" + mon;
    if (year) formatted += "-" + year;

    formattedDateEtadSotReenlistment.value = formatted;

    // Validate month
    let monthIndex = monthsDateEtadSotReenlistment.findIndex(
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
        dateEtadSotReenlistment.value = `${year}-${mm}-${day}`;
        dateEtadSotReenlistmentError.style.display = "none";
    } else {
        dateEtadSotReenlistment.value = "";

        if (formatted.length === 11) {
            dateEtadSotReenlistmentError.style.display = "block";
        }
    }
});
