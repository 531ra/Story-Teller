package com.example.storybook

import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.storybook.databinding.ActivityStoryBinding
import java.util.Locale

class StoryActivity : AppCompatActivity(),TextToSpeech.OnInitListener {
    private var tts:TextToSpeech?=null
    private lateinit var speakableText:String
    private lateinit var binding: ActivityStoryBinding
    private lateinit var storyList:ArrayList<Story>
    private var position=0
    private var isplaying=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_story)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        position = intent.getIntExtra("position", 0)
        storyList = Constants.getStoryList()
        tts=TextToSpeech(this,this)
            
        setStoryView()
        setSpeakableText()

        binding.btnNext.setOnClickListener {
            if (position < storyList.size-1) {
               onChangeStory(1)
            }
         else{
                Toast.makeText(this, "no more story", Toast.LENGTH_SHORT).show()
            }

        }
        binding.btnPrevious.setOnClickListener {
            if (position >0) {
                 onChangeStory(-1)
            }
            else{
                Toast.makeText(this, "no more story", Toast.LENGTH_SHORT).show()
            }

        }
    binding.btnPlay.setOnClickListener { playStroy() }}
        fun setStoryView() {
            val story = storyList[position]
            binding.storyImage.setImageResource(story.image2)
            binding.tvStoryTitle.setText(story.title)
            binding.tvStory.setText(story.story)
            binding.tvMoral.setText(story.moral)

        }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onInit(status: Int) {
       if(status==TextToSpeech.SUCCESS){
           val result=tts!!.setLanguage(Locale.CANADA)
           if(result==TextToSpeech.LANG_MISSING_DATA||result==TextToSpeech.LANG_NOT_SUPPORTED){
               Toast.makeText(this, "language not supported", Toast.LENGTH_SHORT).show()
           }
       }else{
           Toast.makeText(this, "initiate failded", Toast.LENGTH_SHORT).show()
       }
    }
    private fun playStroy(){
        if(!isplaying){
            isplaying=true
            speakOut(speakableText)
            binding.btnPlay.setImageResource(R.drawable.pause)
        }else{
            tts?.stop()
            isplaying=false
            binding.btnPlay.setImageResource(R.drawable.play)
        }
    }
    private fun speakOut(text:String){
        tts?.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")
    }
    private fun onChangeStory(offset:Int){
        tts?.stop()
        position+=offset
        isplaying=false
        setStoryView()
        binding.btnPlay.setImageResource(R.drawable.play)
        setSpeakableText()
    }

    private fun setSpeakableText(){
        speakableText=getString(storyList[position].story)+"Moral of the story"+getString(storyList[position].moral)


    }
    override fun onDestroy() {
        super.onDestroy()
        if(tts!=null){
            tts?.stop()
            tts?.shutdown()
        }



    }
}