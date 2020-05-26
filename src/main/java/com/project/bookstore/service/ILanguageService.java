package com.project.bookstore.service;

import com.project.bookstore.models.Language;

public interface ILanguageService {

    void saveLanguage(Language language);

    boolean isLanguageExist(Language language);
}
