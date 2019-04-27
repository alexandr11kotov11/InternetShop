package com.kotov.dao.daoImpl;


import com.kotov.dao.FeedbackDao;
import com.kotov.model.FeedbackModel;
import org.springframework.stereotype.Repository;

    @Repository("feedbackDAO")
    public class FeedbackDaoImpl extends GenericDaoImpl<FeedbackModel, Long> implements FeedbackDao {
        public FeedbackDaoImpl(Class<FeedbackModel> clazz) {
            super(clazz);
        }

        @Override
        public FeedbackModel getByMail(String customer) {
            return null;
        }
    }

