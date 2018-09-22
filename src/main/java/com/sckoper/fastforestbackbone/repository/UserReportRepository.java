package com.sckoper.fastforestbackbone.repository;

import com.sckoper.fastforestbackbone.entity.UserReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Leon Croft
 * 用户报告操作
 */
public interface UserReportRepository extends JpaRepository<UserReport, Long> {

    /**
     * 根据用户名获取用户报告
     * @param username 用户名
     * @return List
     */
    public List<UserReport> findUserReportsByUserName(String username);

    /**
     * 根据创建时间段获取报告
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return List
     */
    public List<UserReport> findUserReportsByCreatedAtGreaterThanEqualAndCreatedAtLessThanEqual(Timestamp startTime, Timestamp endTime);

    /**
     * 根据上传时间段获取报告
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return List
     */
    public List<UserReport> findUserReportsByUploadedAtGreaterThanEqualAndUploadedAtLessThanEqual(Timestamp startTime, Timestamp endTime);

    /**
     * 根据用户名和创建范围进行检索
     * @param userName 用户名
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    public List<UserReport> findUserReportsByUserNameAndCreatedAtGreaterThanEqualAndCreatedAtLessThanEqual(String userName, Timestamp startTime, Timestamp endTime);

    /**
     * 根据用户名和上传时间范围进行检索
     * @param userName 用户名
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    public List<UserReport> findUserReportsByUserNameAndUploadedAtGreaterThanEqualAndUploadedAtLessThanEqual(String userName, Timestamp startTime, Timestamp endTime);

    /**
     * 根据事件类型获取报告
     * @param eventType 事件类型
     * @return List
     */
    public List<UserReport> findUserReportsByEventType(String eventType);

    /**
     * 根据报告名关键词检索报告
     * @param eventNameKeywords 报告名关键词
     * @return List
     */
    public List<UserReport> findUserReportsByEventNameContaining(String eventNameKeywords);

    /**
     * 根据事件Id获取报告
     * @param eventId 事件Id
     * @return UserReport
     */
    public UserReport findUserReportByReportId(Integer eventId);

    /**
     * 根据报告Id删除报告
     * @param eventId 报告Id
     */
    public void deleteUserReportByReportId(Integer eventId);

    /**
     * 根据事件名删除报告
     * @param eventName 事件名
     */
    public void deleteUserReportByEventName(String eventName);

    /**
     * 根据创建时间批量删除报告
     * @param startTime 开始时间
     * @param endTime 结束时间
     */
    public void deleteUserReportsByCreatedAtGreaterThanEqualAndCreatedAtLessThanEqual(Timestamp startTime, Timestamp endTime);

    /**
     * 根据上传事件时间批量删除报告
     * @param startTime 开始时间
     * @param endTime 结束时间
     */
    public void deleteUserReportsByUploadedAtGreaterThanEqualAndUploadedAtLessThanEqual(Timestamp startTime, Timestamp endTime);
}
