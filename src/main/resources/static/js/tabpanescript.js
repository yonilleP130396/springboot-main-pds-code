function goBack() {
    window.history.back();
  }

  document.addEventListener("DOMContentLoaded", function () {
    // Restore last opened tab
    const lastTabId = localStorage.getItem(lastTabKey);
    if (lastTabId) {
      const trigger = document.querySelector(`a[href="${lastTabId}"]`);
      if (trigger) {
        new bootstrap.Tab(trigger).show();
      }
    }

    // Save tab on change
    const tabs = document.querySelectorAll('#notificationTabs a[data-bs-toggle="tab"]');
    tabs.forEach(tab => {
      tab.addEventListener('shown.bs.tab', function (event) {
        localStorage.setItem(lastTabKey, event.target.getAttribute('href'));
      });
    });
  });