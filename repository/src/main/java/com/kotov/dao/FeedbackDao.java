package com.kotov.dao;

import com.kotov.model.FeedbackModel;

public interface FeedbackDao extends GenericDao<FeedbackModel, Long>{

    FeedbackModel getByMail(String customer);
}
