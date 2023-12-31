package com.ruoyi.eeas.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.eeas.mapper.EventSealedPredictionMapper;
import com.ruoyi.eeas.domain.EventSealedPrediction;
import com.ruoyi.eeas.service.IEventSealedPredictionService;

/**
 * 封控小区预测数据Service业务层处理
 * 
 * @author smj
 * @date 2023-03-31
 */
@Service
public class EventSealedPredictionServiceImpl implements IEventSealedPredictionService 
{
    @Autowired
    private EventSealedPredictionMapper eventSealedPredictionMapper;

    /**
     * 查询封控小区预测数据
     * 
     * @param id 封控小区预测数据主键
     * @return 封控小区预测数据
     */
    @Override
    public EventSealedPrediction selectEventSealedPredictionById(Long id)
    {
        return eventSealedPredictionMapper.selectEventSealedPredictionById(id);
    }

    /**
     * 查询封控小区预测数据列表
     * 
     * @param eventSealedPrediction 封控小区预测数据
     * @return 封控小区预测数据
     */
    @Override
    public List<EventSealedPrediction> selectEventSealedPredictionList(EventSealedPrediction eventSealedPrediction)
    {
        return eventSealedPredictionMapper.selectEventSealedPredictionList(eventSealedPrediction);
    }

    /**
     * 新增封控小区预测数据
     * 
     * @param eventSealedPrediction 封控小区预测数据
     * @return 结果
     */
    @Override
    public int insertEventSealedPrediction(EventSealedPrediction eventSealedPrediction)
    {
        return eventSealedPredictionMapper.insertEventSealedPrediction(eventSealedPrediction);
    }

    /**
     * 修改封控小区预测数据
     * 
     * @param eventSealedPrediction 封控小区预测数据
     * @return 结果
     */
    @Override
    public int updateEventSealedPrediction(EventSealedPrediction eventSealedPrediction)
    {
        return eventSealedPredictionMapper.updateEventSealedPrediction(eventSealedPrediction);
    }

    /**
     * 批量删除封控小区预测数据
     * 
     * @param ids 需要删除的封控小区预测数据主键
     * @return 结果
     */
    @Override
    public int deleteEventSealedPredictionByIds(Long[] ids)
    {
        return eventSealedPredictionMapper.deleteEventSealedPredictionByIds(ids);
    }

    /**
     * 删除封控小区预测数据信息
     * 
     * @param id 封控小区预测数据主键
     * @return 结果
     */
    @Override
    public int deleteEventSealedPredictionById(Long id)
    {
        return eventSealedPredictionMapper.deleteEventSealedPredictionById(id);
    }

    @Override
    public String getPlacesByDateAndTaskId(String date,String taskId){
        EventSealedPrediction eventSealedPrediction=this.eventSealedPredictionMapper.selectEventSealedPredictionByDateAndTaskId(date,taskId);
        return eventSealedPrediction.getPlace();
    }

    /**
     * 根据日期和地点获取对该预测地点产生最高影响的5个场所名称及影响力（弹窗）
     * @param date 日期
     * @param place 地点
     * @param taskId 任务id
     * @param num 个数
     * @return 场所名称及影响力
     */
    @Override
    public List<Map<String, Object>> getPredictionPlaceInfo(String date, String place, String taskId, Integer num) {
        return eventSealedPredictionMapper.getPredictionPlaceInfo(date, place, taskId, num);
    }
}
