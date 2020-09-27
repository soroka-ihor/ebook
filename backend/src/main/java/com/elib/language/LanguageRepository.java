package com.elib.language;

import com.elib.language.model.Language;
import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository extends CrudRepository <Language, Long> {
}
