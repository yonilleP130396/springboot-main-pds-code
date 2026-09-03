const formattedDateAssignedCollateral = document.getElementById("dateassignedcollateralFormatted");
const dateAssignedCollateral = document.getElementById("dateassignedcollateral");
const dateAssignedCollateralError = document.getElementById("dateErrordateassignedcollateral");

const monthsDateAssignedCollateral = ["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];

// ✅ Show existing date in a readable format
if (dateAssignedCollateral.value) {
    let [year, month, day] = dateAssignedCollateral.value.split("-"); // YYYY-MM-DD
    let mon = monthsDateAssignedCollateral[Number(month) - 1];
    formattedDateAssignedCollateral.value = `${day}${mon ? '-' + mon : ''}${year ? '-' + year : ''}`;
}

formattedDateAssignedCollateral.addEventListener("input", () => {
    dateAssignedCollateralError.style.display = "none";

    // Keep only letters & numbers
    let raw = formattedDateAssignedCollateral.value.replace(/[^a-zA-Z0-9]/g, "");

    let day  = raw.slice(0, 2);
    let mon  = raw.slice(2, 5);
    let year = raw.slice(5, 9);

    // Build formatted value
    let formatted = "";
    if (day) formatted += day;
    if (mon) formatted += "-" + mon;
    if (year) formatted += "-" + year;

    formattedDateAssignedCollateral.value = formatted;

    // Validate month
    let monthIndex = monthsDateAssignedCollateral.findIndex(
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
        dateAssignedCollateral.value = `${year}-${mm}-${day}`;
        dateAssignedCollateralError.style.display = "none";
    } else {
        dateAssignedCollateral.value = "";

        if (formatted.length === 11) {
            dateAssignedCollateralError.style.display = "block";
        }
    }
});



//////////////////////////////////////////////////////////////////////////////////////////////////

const formattedDateRelieveCollateral = document.getElementById("daterelievecolateralFormatted");
const dateRelieveCollateral = document.getElementById("daterelieve");
const dateRelieveCollateralError = document.getElementById("dateErrordaterelievecolateral");

const monthsDateRelieveCollateral = ["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];

// ✅ Show existing date in a readable format
if (dateRelieveCollateral.value) {
    let [year, month, day] = dateRelieveCollateral.value.split("-"); // YYYY-MM-DD
    let mon = monthsDateRelieveCollateral[Number(month) - 1];
    formattedDateRelieveCollateral.value = `${day}${mon ? '-' + mon : ''}${year ? '-' + year : ''}`;
}

formattedDateRelieveCollateral.addEventListener("input", () => {
    dateRelieveCollateralError.style.display = "none";

    // Keep only letters & numbers
    let raw = formattedDateRelieveCollateral.value.replace(/[^a-zA-Z0-9]/g, "");

    let day  = raw.slice(0, 2);
    let mon  = raw.slice(2, 5);
    let year = raw.slice(5, 9);

    // Build formatted value
    let formatted = "";
    if (day) formatted += day;
    if (mon) formatted += "-" + mon;
    if (year) formatted += "-" + year;

    formattedDateRelieveCollateral.value = formatted;

    // Validate month
    let monthIndex = monthsDateRelieveCollateral.findIndex(
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
        dateRelieveCollateral.value = `${year}-${mm}-${day}`;
        dateRelieveCollateralError.style.display = "none";
    } else {
        dateRelieveCollateral.value = "";

        if (formatted.length === 11) {
            dateRelieveCollateralError.style.display = "block";
        }
    }
});
