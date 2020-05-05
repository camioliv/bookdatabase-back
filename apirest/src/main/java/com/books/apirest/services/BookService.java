package com.books.apirest.services;

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.apirest.exceptions.ApiRestException;
import com.books.apirest.models.Book;
import com.books.apirest.models.Rating;
import com.books.apirest.recommendation.BookRecommenderBuilder;
import com.books.apirest.repository.BookRepository;
import com.books.apirest.repository.RatingRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private RatingRepository ratingRepository;
	
	public List<Book> findBooks(String query){
		if (query == null||query.isEmpty()){
			return bookRepository.findAll();
		}else {
			query = query.toLowerCase();
			return bookRepository.findAllByTitleContainingOrIsbnEqualsOrAuthorsNameContainingOrTopicsEquals(query, query, query, query);
		}
	}	
	
	public List<Book> recomendBooks(long userId) throws ApiRestException {
		List<Book> booksRecomended = new ArrayList<Book>();
		List<Rating> ratings = ratingRepository.findAllByUserId(userId);
		
		try {
			DataModel userBooks = ratingsToDataModel(ratings);
			Recommender recommender = new BookRecommenderBuilder().buildRecommender(userBooks);
			List<RecommendedItem> recommendations = recommender.recommend(userId, 10, false);
			
		
			for (RecommendedItem recommendation : recommendations) {
				Book book = bookRepository.findById(recommendation.getItemID());
				booksRecomended.add(book);
			}
					
		} catch (Exception e) {
			throw new ApiRestException(e.getMessage());
		}
		return booksRecomended;
	}

	
	private DataModel ratingsToDataModel(List<Rating> ratings) throws ApiRestException{
		LocalDate today = LocalDate.now();	
		String fileName = "file_"+today.toString()+".csv";			
		File file = new File(System.getProperty("java.io.tmpdir") + File.separator + fileName);;
		FileDataModel fileDataModel = null;
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (Rating rating : ratings ) {
				String line = "" + rating.getUser().getId();
				line = line + "," + rating.getBook().getId();
				line = line + "," + rating.getStars();
				writer.write(line);
			}
			
			writer.close();
									
			fileDataModel = new FileDataModel(file);
			
		} catch (Exception e) {
			throw new ApiRestException(e.getMessage());
		}
		return fileDataModel;
	}
}
