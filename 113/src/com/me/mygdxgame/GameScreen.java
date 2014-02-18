package com.me.mygdxgame;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class GameScreen implements Screen{

	private myGame game;
	OrthographicCamera camera;
	SpriteBatch batch;
	private boolean touched;
	private int loopCount=0;
	Texture texture_back;
	Sprite sprite_back;
	public int billX,billY;
	Random rand;
	
	float state_time;
	
	Vector3 touch;
	
	Bill bill;
	Steve steve;
	
	public float time = 0;
	public GameScreen(myGame game){
		this.game = game;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 1920, 1080);
		
		batch = new SpriteBatch();
				rand = new Random();
		state_time = 0F;
		
		touch = new Vector3();
		bill = new Bill();
		steve = new Steve();
	
	}
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
		Gdx.gl.glClearColor(.95F, 1F, 1F, 1F);  //starts as black
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); //clears to white
		
		camera.update();
		generalUpdate(touch, camera);
		
		
		state_time += Gdx.graphics.getDeltaTime();
		//Assets.current_frame = Assets.loading_animation.getKeyFrame(state_time, true);
		
		
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		batch.draw(Assets.sprite_back, 0, 0, 1920, 1080);
		//batch.draw(Assets.sprite_1, 256, 256);
		//Assets.current_frame = Assets.bill.getKeyFrame(time += delta, false);
		Assets.current_frame = Assets.bill.getKeyFrame(state_time, false);
		//batch.draw(Assets.current_frame, 100, 100);
		//batch.draw(bill.image, bill.bounds.x, bill.bounds.y);
		//batch.draw(steve.image, steve.bounds.x, steve.bounds.y);
	
		
		batch.draw(Assets.current_frame, billX, billY+=3);
		touched = false;
		
//		for (int i=0;i<20;i++){
//			batch.draw(Assets.sheet_frames[i],512,512);
//		}
		//draws on whole screen
//		for (int i=0; i < 1920; i+=16){
//			for (int j=0; j < 1080; j+=16){
//				//switch(rand.nextInt(2)){
//				//case 0:
//					batch.draw(Assets.sprite_1, i, j);
//					//break;
//				
//				//}
//			}
//		}
		
		
		batch.end();
	}

	private void generalUpdate(Vector3 touch, OrthographicCamera camera) {
		// TODO Auto-generated method stub
		if (Gdx.input.isKeyPressed(Keys.W)){
			bill.bounds.y -= 5;
		}
		if (Gdx.input.isKeyPressed(Keys.S)){
			bill.bounds.y += 5;
		}	
		if (Gdx.input.isKeyPressed(Keys.D)){
			bill.bounds.x += 5;
		}	
		if (Gdx.input.isKeyPressed(Keys.A)){
			bill.bounds.x -= 5;
		}	
		if (Gdx.input.justTouched()){
			state_time=0;
			touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touch);
			billX = (int)touch.x - 64;
			billY = (int)touch.y - 254;
			//if (bill.bounds.y > billY)
				bill.bounds.y += 5;
	}
//		if (Gdx.input.justTouched()){
//			//bill.bounds.x -= 5;
//			touched = true;
//			//touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
//			camera.unproject(touch); //translates touch to screen size
//		}
		//bill.bounds.x += 5;
		
	}
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
