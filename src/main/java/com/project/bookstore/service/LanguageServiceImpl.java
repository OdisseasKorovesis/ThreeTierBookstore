package com.project.bookstore.service;

import com.project.bookstore.models.Language;
import com.project.bookstore.repository.RepositoryLanguages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("languageService")
public class LanguageServiceImpl implements ILanguageService {

    @Autowired
    private RepositoryLanguages repositoryLanguages;

    @Override
    public void saveLanguage(Language language) {
        repositoryLanguages.save(language);
    }

    @Override
    public boolean isLanguageExist(Language language) {
        if (repositoryLanguages.findByName(language.getName()) == null) {
            return false;
        } else {
            return true;
        }
    }

}
