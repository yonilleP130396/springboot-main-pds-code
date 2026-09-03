const input = document.getElementById('afpsn');

  input.addEventListener('input', function () {
    // Allow only O, -, and numbers 0-9
    this.value = this.value.replace(/[^O0-9-]/g, '');
  });