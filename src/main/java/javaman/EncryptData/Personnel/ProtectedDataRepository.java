
package javaman.EncryptData.Personnel;


// import java.util.List;
// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Modifying;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

// import jakarta.transaction.Transactional;


public interface ProtectedDataRepository extends JpaRepository<ProtectedDataEntity, Long> {
    

//     //long countByMilitaryStatus(MilitaryStatus militaryStatus);

//     @Query(value = "SELECT COUNT(*) FROM personal_information_tbl p WHERE p.military_status = :statusId AND p.is_deleted = 0 AND (p.status_definition_category IS NULL OR LOWER(p.status_definition_category) NOT IN ('resigned', 'retired', 'awol','discharge', 'disease'))",nativeQuery = true)
//     long countByMilitaryStatus(@Param("statusId") Integer statusId);


//     @Query("SELECT pd FROM ProtectedData pd LEFT JOIN FETCH pd.assignments")
//     List<ProtectedData> findAllWithAssignments();

//     List<ProtectedData> findByAfpsnContaining(String afpsn);
    
//     List<ProtectedData> findByAfpsnNotContaining(String afpsn);

   
//     //repository for users

//     List<ProtectedData> findByUserId(myUser userId);

//     List<ProtectedData> findByUserId(String userId);
    
//     @Query("SELECT p FROM ProtectedData p WHERE p.userId = :userId AND (p.status_definition_category IS NULL OR LOWER(p.status_definition_category) NOT IN ('resigned', 'retired', 'awol','discharge', 'disease'))")
//     List<ProtectedData> findByUserIdAndStatusNotResigned(@Param("userId") String userId);

//     ProtectedData findByIdAndUserId(Long id, myUser userId);

//    @Query("SELECT p FROM ProtectedData p LEFT JOIN MilitarySchooling m ON p = m.serialNumber WHERE m.serialNumber IS NULL ORDER BY p.sortednumber ASC")
//     List<ProtectedData> findAllNotInMilitarySchooling();

//     @Query("SELECT p FROM ProtectedData p WHERE p.status_definition_category = :status")
//     List<ProtectedData> findByStatusDefinitionCategory(@Param("status") String status_definition_category);

//    @Query(value = "SELECT COUNT(*) AS total_count FROM personal_information_tbl p WHERE p.is_deleted = 0 AND p.status_definition_category = :status ",nativeQuery = true)
//     long countByStatusDefinitionCategory(@Param("status") String status_definition_category);

//     @Query("SELECT p FROM ProtectedData p ORDER BY p.fosRating ASC, p.sortednumber ASC")
//     List<ProtectedData> findAllByOrderByFosRatingAscSortedNumberAsc();

//     Optional<ProtectedData> findByAfpsn(String afpsn);

//     @Query(value = "SELECT * FROM personal_information_tbl p WHERE p.is_deleted = 0 AND (p.status_definition_category IS NULL OR LOWER(p.status_definition_category) NOT IN ('resigned', 'retired', 'awol' ,'discharge', 'disease')) ORDER BY p.sorted_number ASC", nativeQuery = true)
//     List<ProtectedData> findAllNotResignedOrdered();

//     @Query(value = "SELECT * FROM personal_information_tbl p WHERE p.is_deleted = 0 AND (p.status_definition_category IS NULL OR LOWER(p.status_definition_category) IN ('resigned', 'retired', 'awol' ,'discharge', 'disease')) ORDER BY p.sorted_number ASC", nativeQuery = true)
//     List<ProtectedData> findAllAttritionOrdered();

//     boolean existsByAfpsn(String afpsn);

//     @Modifying
//     @Transactional
//     @Query(value = "UPDATE personal_information_tbl SET is_deleted = 1 WHERE id = :id",nativeQuery = true)
//     int markAsDeleted(@Param("id") Long id);

//     @Query( value = "SELECT p.*, r.mode_of_retirement, r.date_of_retirement FROM personal_information_tbl p INNER JOIN retirement_requests_tbl r ON p.id = r.personnel_id WHERE r.date_of_retirement >= CURDATE()", nativeQuery = true )
//     List<Object[]> dueForRetirements();

//     @Query(
//         value = """
//             SELECT 
//                 p.*,
//                 ao.name AS name
//             FROM personal_information_tbl p
//             LEFT JOIN nipmb_db.account_offices ao
//                 ON p.user_id = ao.id
//             WHERE p.region IS NULL
//                OR TRIM(p.region) = ''
//                OR LENGTH(TRIM(p.region)) < 3
//         """,
//         nativeQuery = true
//     )
//     List<Object[]> findInvalidRegionWithEncoder();

//     @Query("SELECT p FROM ProtectedData p WHERE p.isDeleted = 0 AND (p.status_definition_category IS NULL OR LOWER(p.status_definition_category) NOT IN ('resigned', 'retired', 'awol','discharge', 'disease')) AND p.rankCode LIKE 'E%' ORDER BY p.sortednumber ASC")
//     List<ProtectedData> findAllNotResignedOrderedJPA();
}
