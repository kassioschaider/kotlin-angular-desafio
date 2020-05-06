package com.kassioschaider.challenge.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.function.Consumer

@RestControllerAdvice
class ErroValidationHandler(private @field:Autowired val messageSource: MessageSource? = null) {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleFields(exception: MethodArgumentNotValidException): ArrayList<ErrorDTO> {
        val dtoList = ArrayList<ErrorDTO>()
        val fieldErrors = exception.bindingResult.fieldErrors
        fieldErrors.forEach(Consumer { e: FieldError ->
            val message = messageSource!!.getMessage(e, LocaleContextHolder.getLocale())
            val error = ErrorDTO(fieldToTitle(e.field), message)
            dtoList.add(error)
        })
        return dtoList
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handlerJson(exception: HttpMessageNotReadableException): ArrayList<ErrorDTO> {
        val dtoList = ArrayList<ErrorDTO>()
        val erro = ErrorDTO(fieldToTitle("JSON"), exception.mostSpecificCause.message)
        dtoList.add(erro)
        return dtoList
    }

    private fun fieldToTitle(field: String): String {
        return when (field) {
            "title" -> "Title"
            "type" -> "Type"
            "price" -> "Price"
            "json" -> "Json"
            else -> field
        }
    }
}