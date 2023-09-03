package com.example.tp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import com.example.tp.MainViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.junit.Assert.assertEquals

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class TestUnitario {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    @Mock
    private lateinit var observer: Observer<String>

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = MainViewModel(ApplicationProvider.getApplicationContext())
        viewModel.result.observeForever(observer)
    }

    @Test
    fun testCompareWords() {
        assertEquals("Faltan ambos textos", viewModel.compareWords("", ""))
        assertEquals("Falta un texto", viewModel.compareWords("", "Texto"))
        assertEquals("Falta un texto", viewModel.compareWords("Texto", ""))
        assertEquals("Texto similales", viewModel.compareWords("Hola", "Hola"))
        assertEquals("Textos distintos", viewModel.compareWords("Hla", "Mundo"))


        println("TEST OK")

    }
}


