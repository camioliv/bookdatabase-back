package com.books.apirest.recommendation;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;

public class BookRecommenderBuilder implements RecommenderBuilder {

	@Override
	public Recommender buildRecommender(DataModel dataModel) throws TasteException {
		
		UserSimilarity userSimilarity = new PearsonCorrelationSimilarity(dataModel);
		
		UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, userSimilarity, dataModel);
		
		UserBasedRecommender recommender = new GenericUserBasedRecommender(dataModel, neighborhood, userSimilarity);
		
		return recommender;
	}

}

