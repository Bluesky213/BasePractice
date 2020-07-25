/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


/**
 *
 * @author Bluesky
 */
public class Example_Json2 {
    public static void main(String args[]) throws JSONException{
        HashMap<String,Object> face_info = new HashMap();
        String jsonstr="{\"image_id\": \"lC2Leug7wfWlVBwDlEMQ9A==\", \"request_id\": \"1515394115,d8e51af7-8412-4fba-ba28-31674e829c91\", \"time_used\": 246, \"faces\": [{\"landmark\": {\"mouth_upper_lip_left_contour2\": {\"y\": 88, \"x\": 54}, \"mouth_upper_lip_left_contour3\": {\"y\": 90, \"x\": 56}, \"mouth_lower_lip_right_contour3\": {\"y\": 94, \"x\": 64}, \"mouth_upper_lip_left_contour1\": {\"y\": 86, \"x\": 58}, \"left_eye_upper_left_quarter\": {\"y\": 62, \"x\": 46}, \"left_eyebrow_lower_middle\": {\"y\": 56, \"x\": 48}, \"contour_chin\": {\"y\": 109, \"x\": 60}, \"left_eyebrow_lower_left_quarter\": {\"y\": 56, \"x\": 44}, \"right_eyebrow_lower_left_quarter\": {\"y\": 57, \"x\": 71}, \"mouth_lower_lip_right_contour1\": {\"y\": 91, \"x\": 65}, \"mouth_lower_lip_left_contour2\": {\"y\": 92, \"x\": 54}, \"left_eye_bottom\": {\"y\": 64, \"x\": 48}, \"mouth_lower_lip_bottom\": {\"y\": 94, \"x\": 60}, \"contour_left9\": {\"y\": 108, \"x\": 52}, \"mouth_lower_lip_top\": {\"y\": 90, \"x\": 60}, \"right_eyebrow_upper_middle\": {\"y\": 54, \"x\": 75}, \"right_eyebrow_left_corner\": {\"y\": 56, \"x\": 67}, \"right_eye_bottom\": {\"y\": 66, \"x\": 74}, \"contour_left7\": {\"y\": 100, \"x\": 41}, \"contour_left6\": {\"y\": 95, \"x\": 37}, \"contour_left5\": {\"y\": 89, \"x\": 35}, \"contour_left4\": {\"y\": 83, \"x\": 33}, \"contour_left3\": {\"y\": 76, \"x\": 33}, \"contour_left2\": {\"y\": 70, \"x\": 33}, \"contour_left1\": {\"y\": 63, \"x\": 33}, \"left_eye_lower_left_quarter\": {\"y\": 64, \"x\": 46}, \"mouth_upper_lip_top\": {\"y\": 87, \"x\": 60}, \"contour_right3\": {\"y\": 79, \"x\": 88}, \"contour_right2\": {\"y\": 72, \"x\": 89}, \"mouth_left_corner\": {\"y\": 91, \"x\": 51}, \"contour_right4\": {\"y\": 85, \"x\": 87}, \"contour_right7\": {\"y\": 102, \"x\": 78}, \"left_eyebrow_left_corner\": {\"y\": 56, \"x\": 41}, \"nose_right\": {\"y\": 80, \"x\": 69}, \"right_eye_upper_right_quarter\": {\"y\": 63, \"x\": 76}, \"nose_tip\": {\"y\": 76, \"x\": 61}, \"contour_right5\": {\"y\": 91, \"x\": 85}, \"nose_contour_lower_middle\": {\"y\": 82, \"x\": 61}, \"right_eye_top\": {\"y\": 63, \"x\": 74}, \"mouth_lower_lip_left_contour3\": {\"y\": 94, \"x\": 56}, \"right_eye_right_corner\": {\"y\": 65, \"x\": 79}, \"right_eye_lower_right_quarter\": {\"y\": 65, \"x\": 76}, \"mouth_upper_lip_right_contour2\": {\"y\": 88, \"x\": 66}, \"right_eyebrow_lower_right_quarter\": {\"y\": 57, \"x\": 78}, \"left_eye_left_corner\": {\"y\": 63, \"x\": 43}, \"mouth_right_corner\": {\"y\": 91, \"x\": 69}, \"mouth_upper_lip_right_contour3\": {\"y\": 90, \"x\": 65}, \"right_eye_lower_left_quarter\": {\"y\": 65, \"x\": 71}, \"left_eyebrow_right_corner\": {\"y\": 56, \"x\": 55}, \"left_eyebrow_lower_right_quarter\": {\"y\": 56, \"x\": 51}, \"right_eye_center\": {\"y\": 65, \"x\": 74}, \"left_eye_upper_right_quarter\": {\"y\": 62, \"x\": 51}, \"mouth_lower_lip_left_contour1\": {\"y\": 90, \"x\": 56}, \"contour_left8\": {\"y\": 105, \"x\": 46}, \"nose_left\": {\"y\": 79, \"x\": 53}, \"right_eyebrow_lower_middle\": {\"y\": 57, \"x\": 75}, \"left_eye_top\": {\"y\": 61, \"x\": 48}, \"left_eye_center\": {\"y\": 63, \"x\": 48}, \"left_eye_lower_right_quarter\": {\"y\": 64, \"x\": 51}, \"nose_contour_right1\": {\"y\": 65, \"x\": 66}, \"contour_right9\": {\"y\": 108, \"x\": 67}, \"right_eye_left_corner\": {\"y\": 65, \"x\": 69}, \"left_eyebrow_upper_left_quarter\": {\"y\": 53, \"x\": 44}, \"left_eye_pupil\": {\"y\": 63, \"x\": 48}, \"right_eyebrow_upper_left_quarter\": {\"y\": 54, \"x\": 71}, \"contour_right8\": {\"y\": 105, \"x\": 73}, \"right_eyebrow_right_corner\": {\"y\": 58, \"x\": 82}, \"right_eye_upper_left_quarter\": {\"y\": 63, \"x\": 71}, \"left_eyebrow_upper_middle\": {\"y\": 53, \"x\": 48}, \"right_eyebrow_upper_right_quarter\": {\"y\": 55, \"x\": 79}, \"nose_contour_left1\": {\"y\": 64, \"x\": 57}, \"nose_contour_left2\": {\"y\": 74, \"x\": 55}, \"mouth_upper_lip_right_contour1\": {\"y\": 86, \"x\": 63}, \"contour_right1\": {\"y\": 66, \"x\": 89}, \"nose_contour_right2\": {\"y\": 75, \"x\": 67}, \"mouth_lower_lip_right_contour2\": {\"y\": 93, \"x\": 66}, \"contour_right6\": {\"y\": 97, \"x\": 82}, \"nose_contour_right3\": {\"y\": 81, \"x\": 65}, \"nose_contour_left3\": {\"y\": 81, \"x\": 57}, \"left_eye_right_corner\": {\"y\": 64, \"x\": 53}, \"left_eyebrow_upper_right_quarter\": {\"y\": 53, \"x\": 52}, \"right_eye_pupil\": {\"y\": 64, \"x\": 73}, \"mouth_upper_lip_bottom\": {\"y\": 90, \"x\": 60}}, \"attributes\": {\"emotion\": {\"sadness\": 0.004, \"neutral\": 99.974, \"disgust\": 0.001, \"anger\": 0.004, \"surprise\": 0.016, \"fear\": 0.001, \"happiness\": 0.001}, \"beauty\": {\"female_score\": 53.374, \"male_score\": 51.533}, \"gender\": {\"value\": \"Male\"}, \"age\": {\"value\": 15}, \"mouthstatus\": {\"close\": 1.281, \"surgical_mask_or_respirator\": 0.0, \"open\": 0.0, \"other_occlusion\": 98.719}, \"glass\": {\"value\": \"None\"}, \"skinstatus\": {\"dark_circle\": 9.981, \"stain\": 5.099, \"acne\": 4.66, \"health\": 52.657}, \"headpose\": {\"yaw_angle\": 4.6524453, \"pitch_angle\": 0.25283992, \"roll_angle\": 1.912629}, \"blur\": {\"blurness\": {\"threshold\": 50.0, \"value\": 0.471}, \"motionblur\": {\"threshold\": 50.0, \"value\": 0.471}, \"gaussianblur\": {\"threshold\": 50.0, \"value\": 0.471}}, \"smile\": {\"threshold\": 30.1, \"value\": 0.527}, \"eyestatus\": {\"left_eye_status\": {\"normal_glass_eye_open\": 1.421, \"no_glass_eye_close\": 0.0, \"occlusion\": 0.004, \"no_glass_eye_open\": 98.575, \"normal_glass_eye_close\": 0.001, \"dark_glasses\": 0.0}, \"right_eye_status\": {\"normal_glass_eye_open\": 0.256, \"no_glass_eye_close\": 0.0, \"occlusion\": 0.001, \"no_glass_eye_open\": 99.742, \"normal_glass_eye_close\": 0.001, \"dark_glasses\": 0.0}}, \"facequality\": {\"threshold\": 70.1, \"value\": 91.824}, \"ethnicity\": {\"value\": \"Asian\"}, \"eyegaze\": {\"right_eye_gaze\": {\"position_x_coordinate\": 0.514, \"vector_z_component\": 0.969, \"vector_x_component\": -0.06, \"vector_y_component\": 0.238, \"position_y_coordinate\": 0.414}, \"left_eye_gaze\": {\"position_x_coordinate\": 0.493, \"vector_z_component\": 0.994, \"vector_x_component\": 0.016, \"vector_y_component\": 0.105, \"position_y_coordinate\": 0.403}}}, \"face_rectangle\": {\"width\": 57, \"top\": 52, \"left\": 31, \"height\": 57}, \"face_token\": \"92d1e91b7b68dab546a290eb3704a8d7\"}]}";
        JSONObject json=new JSONObject(jsonstr);
        //---4---
            JSONObject Json_image_id=new JSONObject(jsonstr);
                face_info.put("Json_image_id", Json_image_id.get("image_id"));
               System.out.println(face_info.get("Json_image_id"));
            JSONObject Json_request_id=new JSONObject(jsonstr);
                face_info.put("Json_request_id", Json_image_id.get("request_id"));
            JSONObject Json_time_used=new JSONObject(jsonstr);
                face_info.put("Json_time_used", Json_image_id.get("time_used"));
            JSONArray faces=json.getJSONArray("faces");
            //---1---
                JSONObject Json_face_0=faces.getJSONObject(0);//第一个人脸对象
                //---4---
                    JSONObject Json_landmark =Json_face_0.getJSONObject("landmark");//分析人脸的106点数据——此行数据不存
                    
                    JSONObject Json_attributes =Json_face_0.getJSONObject("attributes");//分析人脸的相貌特征——此行存
                        //1.age
                        JSONObject Json_age =Json_attributes.getJSONObject("age");
                            face_info.put("attribute_age", Json_age.getInt("value"));
                            System.out.println(face_info.get("attribute_age"));
                        //2.beauty
                        JSONObject Json_beauty =Json_attributes.getJSONObject("beauty");
                            face_info.put("attribute_beauty_female_score", Json_beauty.getDouble("female_score"));
                            face_info.put("attribute_beauty_male_score", Json_beauty.getDouble("male_score"));
                        //3.blur
                        JSONObject Json_blur =Json_attributes.getJSONObject("blur");
                            JSONObject Json_blurness =Json_blur.getJSONObject("blurness");
                                int blurness_threshold=Json_blurness.getInt("threshold");
                                int blurness_value=Json_blurness.getInt("value");
                            JSONObject Json_motionblur =Json_blur.getJSONObject("motionblur");
                                int motionblur_threshold=Json_motionblur.getInt("threshold");
                                int motionblur_value=Json_motionblur.getInt("threshold");
                            JSONObject Json_gaussianblur =Json_blur.getJSONObject("gaussianblur");
                                int gaussianblur_threshold=Json_gaussianblur.getInt("threshold");
                                int gaussianblur_value=Json_gaussianblur.getInt("threshold");
                        //4.emotion
                        JSONObject Json_emotion =Json_attributes.getJSONObject("emotion");
                            face_info.put("attribute_emotion_anger", Json_emotion.getDouble("anger"));
                            face_info.put("attribute_emotion_disgust", Json_emotion.getDouble("disgust"));
                            face_info.put("attribute_emotion_fear", Json_emotion.getDouble("fear"));
                            face_info.put("attribute_emotion_happiness", Json_emotion.getDouble("happiness"));
                            face_info.put("attribute_emotion_neutral", Json_emotion.getDouble("neutral"));
                            face_info.put("attribute_emotion_sadness", Json_emotion.getDouble("sadness"));
                            face_info.put("attribute_emotion_surprise", Json_emotion.getDouble("surprise"));
                        //5.ethnicity
                        JSONObject Json_ethnicity =Json_attributes.getJSONObject("ethnicity");
                            String attribute_ethnicity_value=Json_ethnicity.getString("value");
                            face_info.put("attribute_ethnicity_value", Json_ethnicity.getString("value"));
                        //6.eyegaze
                        JSONObject Json_eyegaze =Json_attributes.getJSONObject("eyegaze");
                            JSONObject Json_left_eye_gaze =Json_eyegaze.getJSONObject("left_eye_gaze");
                                double left_eye_gaze_position_x_coordinate=Json_left_eye_gaze.getDouble("position_x_coordinate");
                                double left_eye_gaze_position_y_coordinate=Json_left_eye_gaze.getDouble("position_y_coordinate");
                                double left_eye_gaze_vector_x_component=Json_left_eye_gaze.getDouble("vector_x_component");
                                double left_eye_gaze_vector_y_component=Json_left_eye_gaze.getDouble("vector_y_component");
                                double left_eye_gaze_vector_z_component=Json_left_eye_gaze.getDouble("vector_z_component");
                            JSONObject Json_right_eye_gaze =Json_eyegaze.getJSONObject("right_eye_gaze");
                                double right_eye_gaze_position_x_coordinate=Json_right_eye_gaze.getDouble("position_x_coordinate");
                                double right_eye_gaze_position_y_coordinate=Json_right_eye_gaze.getDouble("position_y_coordinate");
                                double right_eye_gaze_vector_x_component=Json_right_eye_gaze.getDouble("vector_x_component");
                                double right_eye_gaze_vector_y_component=Json_right_eye_gaze.getDouble("vector_y_component");
                                double right_eye_vector_z_component=Json_right_eye_gaze.getDouble("vector_z_component");  
                        //7.eyestatus
                        JSONObject Json_eyestatus =Json_attributes.getJSONObject("eyestatus");
                            JSONObject Json_left_eye_status =Json_eyestatus.getJSONObject("left_eye_status");
                            //
                            JSONObject Json_right_eye_status =Json_eyestatus.getJSONObject("right_eye_status");
                            //
                        //8.facequality
                        JSONObject Json_facequality =Json_attributes.getJSONObject("facequality");
                            face_info.put("attribute_facequality_threshold", Json_facequality.getDouble("threshold"));
                            face_info.put("attribute_facequality_value", Json_facequality.getDouble("value"));
                        //9.gender
                        JSONObject Json_gender =Json_attributes.getJSONObject("gender");
                            face_info.put("attribute_gender_value", Json_gender.getString("value"));
                        //10.glass
                        JSONObject Json_glass =Json_attributes.getJSONObject("glass");
                            face_info.put("attribute_glass_value", Json_glass.getString("value"));
                        //11.headpose
                        JSONObject Json_headpose =Json_attributes.getJSONObject("headpose");
                            //face_info.put("pitch_angle", Json_headpose.getDouble("pitch_angle"));
                            //face_info.put("roll_angle", Json_headpose.getDouble("roll_angle"));
                            //face_info.put("yaw_angle", Json_headpose.getDouble("yaw_angle"));
                        //12.mouthstatus
                        JSONObject Json_mouthstatus =Json_attributes.getJSONObject("mouthstatus");
                            //face_info.put("Json_mouthstatus", Json_attributes.getJSONObject("mouthstatus"));
                            //
                        //13.skinstatus
                        JSONObject Json_skinstatus =Json_attributes.getJSONObject("skinstatus");
                            face_info.put("attribute_skinstatus_acne", Json_skinstatus.getDouble("acne"));
                            face_info.put("attribute_skinstatus_dark_circle", Json_skinstatus.getDouble("dark_circle"));
                            face_info.put("attribute_skinstatus_health", Json_skinstatus.getDouble("health"));
                            face_info.put("attribute_skinstatus_stain", Json_skinstatus.getDouble("stain"));
                       //14.smile
                        JSONObject Json_smile =Json_attributes.getJSONObject("smile");
                            face_info.put("attribute_smile_threshold", Json_smile.getDouble("threshold"));
                            face_info.put("attribute_smile_value", Json_smile.getDouble("value"));
                    JSONObject Json_face_rectangle =Json_face_0.getJSONObject("face_rectangle");
                        face_info.put("face_rectangle_width", Json_face_rectangle.getInt("width"));
                        face_info.put("face_rectangle_height", Json_face_rectangle.getInt("height"));
                        face_info.put("face_rectangle_top", Json_face_rectangle.getInt("top"));
                        face_info.put("face_rectangle_left", Json_face_rectangle.getInt("left"));
                        
                    String face_token=Json_face_0.getString("face_token");
                        face_info.put("face_token", Json_face_0.getString("face_token"));
                     
    }

    
}
