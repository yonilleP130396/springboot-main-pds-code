
  document.querySelectorAll(".date-dd-mmm-yyyy").forEach(td => {
    if (!td.textContent.trim()) return;

    const date = new Date(td.textContent.trim());

    if (isNaN(date)) return;

    const formattedDate = date.toLocaleDateString("en-GB", {
      day: "2-digit",
      month: "short",
      year: "numeric"
    });

    td.textContent = formattedDate;
  });
