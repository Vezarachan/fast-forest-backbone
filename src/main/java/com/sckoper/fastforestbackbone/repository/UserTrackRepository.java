package com.sckoper.fastforestbackbone.repository;

import com.sckoper.fastforestbackbone.entity.UserTrack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Leon Croft
 * 用户轨迹数据操作
 */
public interface UserTrackRepository extends JpaRepository<UserTrack, Long> {

    /**
     * 根据用户名寻找用户轨迹点
     * @param userName 用户名
     * @return List
     */
    public List<UserTrack> findUserTracksByUsername(String userName);

    /**
     * 根据用户名以及日期查找用户轨迹点
     * @param userName 用户名
     * @param createdAt 创建时间
     * @return List
     */
    @Query(value = "SELECT * FROM user_track WHERE username = ?1 AND TO_DATE(createdat, 'yyyy-MM-dd') = TO_DATE(?2, 'yyyy-MM-dd')", nativeQuery = true)
    public List<UserTrack> findUserTracksByUsernameAndCreatedAtEquals(String userName, Timestamp createdAt);

    /**
     * 分用户根据时间段查找用户轨迹点
     * @param userName 用户名
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return List
     */
    public List<UserTrack> findUserTracksByUsernameAndCreatedAtGreaterThanEqualAndCreatedAtLessThanEqual(String userName, Timestamp startTime, Timestamp endTime);

    /**
     * 根据时间段查找用户轨迹点
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return List
     */
    public List<UserTrack> findUserTracksByCreatedAtGreaterThanEqualAndCreatedAtLessThanEqual(Timestamp startTime, Timestamp endTime);

    /**
     * 根据用户名删除轨迹记录
     * @param userName 用户名
     */
    public void deleteUserTracksByUsername(String userName);
}
