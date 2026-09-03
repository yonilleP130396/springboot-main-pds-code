
        // Inject Thymeleaf list safely
        const rawProtectedDataList = /*[[${protecteddata}]]*/ [];
    
        // Flatten and process the data for JS usage
        let processedJsArray = rawProtectedDataList.map(data => ({
            id: data.id || "",
            rank: data.rank || "",
            firstname: data.firstname || "",
            middlename: data.middlename || "",
            lastname: data.lastname || "",
            extension: data.extension || "",
            afpsn: data.afpsn || "",
            bosname: data.bosname || "",
            unitname: data.unitname || "",
            fosratingname: data.fosratingname || "",
            presentassignment: data.presentassignment || "",
            fieldduty: data.fieldduty || "",
            sortednumber: data.sortednumber || ""
        }));
    
        function dataTableTwo() {
            return {
                search: "",
                sortColumn: "firstname",
                sortDirection: "asc",
                currentPage: 1,
                perPage: 10,
                data: processedJsArray,
    
                // Pagination Pages
                get pagesAroundCurrent() {
                    const pages = [];
                    const start = Math.max(2, this.currentPage - 2);
                    const end = Math.min(this.totalPages - 1, this.currentPage + 2);
                    for (let p = start; p <= end; p++) pages.push(p);
                    return pages;
                },
    
                // Filtering + Sorting
                get filteredData() {
                    const search = this.search.toLowerCase();
                    return this.data
                        .filter(p =>
                            p.firstname.toLowerCase().includes(search) ||
                            p.lastname.toLowerCase().includes(search) ||
                            p.middlename.toLowerCase().includes(search) ||
                            p.rank.toLowerCase().includes(search) ||
                            p.bosname.toLowerCase().includes(search) ||
                            p.unitname.toLowerCase().includes(search) ||
                            p.fosratingname.toLowerCase().includes(search) ||
                            p.presentassignment.toLowerCase().includes(search) ||
                            p.fieldduty.toLowerCase().includes(search)
                        )
                        .sort((a, b) => {
                            const m = this.sortDirection === "asc" ? 1 : -1;
                            return a[this.sortColumn] < b[this.sortColumn] ? -1 * m :
                                   a[this.sortColumn] > b[this.sortColumn] ? 1 * m : 0;
                        });
                },
    
                // Pagination
                get paginatedData() {
                    const start = (this.currentPage - 1) * this.perPage;
                    return this.filteredData.slice(start, start + this.perPage);
                },
    
                get totalEntries() { return this.filteredData.length; },
                get startEntry() { return (this.currentPage - 1) * this.perPage + 1; },
                get endEntry() { return Math.min(this.currentPage * this.perPage, this.totalEntries); },
                get totalPages() { return Math.ceil(this.totalEntries / this.perPage); },
    
                goToPage(page) { if (page >= 1 && page <= this.totalPages) this.currentPage = page; },
                nextPage() { if (this.currentPage < this.totalPages) this.currentPage++; },
                prevPage() { if (this.currentPage > 1) this.currentPage--; },
    
                sortBy(column) {
                    if (this.sortColumn === column) {
                        this.sortDirection = this.sortDirection === "asc" ? "desc" : "asc";
                    } else {
                        this.sortColumn = column;
                        this.sortDirection = "asc";
                    }
                }
            };
        }
    