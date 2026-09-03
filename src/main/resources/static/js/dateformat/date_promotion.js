const formattedDatePromoted = document.getElementById("datepromotedFormatted");
const datePromoted = document.getElementById("datepromoted");
const datePromotedError = document.getElementById("dateErrordatepromoted");

const monthsDatePromoted = ["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];

// ✅ Show existing date in a readable format
if (datePromoted.value) {
    let [year, month, day] = datePromoted.value.split("-"); // YYYY-MM-DD
    let mon = monthsDatePromoted[Number(month) - 1];
    formattedDatePromoted.value = `${day}${mon ? '-' + mon : ''}${year ? '-' + year : ''}`;
}

formattedDatePromoted.addEventListener("input", () => {
    datePromotedError.style.display = "none";

    // Keep only letters & numbers
    let raw = formattedDatePromoted.value.replace(/[^a-zA-Z0-9]/g, "");

    let day  = raw.slice(0, 2);
    let mon  = raw.slice(2, 5);
    let year = raw.slice(5, 9);

    // Build formatted value
    let formatted = "";
    if (day) formatted += day;
    if (mon) formatted += "-" + mon;
    if (year) formatted += "-" + year;

    formattedDatePromoted.value = formatted;

    // Validate month
    let monthIndex = monthsDatePromoted.findIndex(
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
        datePromoted.value = `${year}-${mm}-${day}`;
        datePromotedError.style.display = "none";
    } else {
        datePromoted.value = "";

        if (formatted.length === 11) {
            datePromotedError.style.display = "block";
        }
    }
});
